package services;

import DTO.*;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import models.Book;
import models.ItemsBorrowed;
import models.DVD;
import models.LibraryItem;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WestminsterLibraryManager implements LibraryManager {

    private static final Model.Finder<Long, Book> searchBook = new Model.Finder<>(Book.class);
    private static final Model.Finder<Long, DVD> searchDVD = new Model.Finder<>(DVD.class);
    private static final Model.Finder<Long, ItemsBorrowed> searchBorrowHistory = new Model.Finder<>(ItemsBorrowed.class);

    @Override
    public ItemCountDTO addItems() {

        ItemCountDTO countItemsDTO;

        int bookCount = searchBook.findRowCount();
        int dvdCount = searchDVD.findRowCount();

        int itemTotal = bookCount + dvdCount;

        if(itemTotal > 0){

            int booksRemaining = 100 - bookCount;
            int dvdsRemaining = 50 - dvdCount;

            countItemsDTO = new ItemCountDTO(booksRemaining,dvdsRemaining);

        }else{
            countItemsDTO = new ItemCountDTO(100,50);
        }

        return countItemsDTO;

    }

    //saving the items to the database
    @Override
    public boolean saveNewItem(AddNewItemDTO addItemsDTO) {

        boolean isSuccessfullySaved;

        if(addItemsDTO.getBook() != null){
            Ebean.save(addItemsDTO.getBook());
            isSuccessfullySaved = true;
        }else if(addItemsDTO.getDvd() != null){
            Ebean.save(addItemsDTO.getDvd());
            isSuccessfullySaved = true;
        }else{
            isSuccessfullySaved = false;
        }

        return isSuccessfullySaved;
    }

    @Override
    public DeleteItemsDTO deleteAnItem(String TypeIsbn) {

        DeleteItemsDTO deleteItemsDTO;

        String itemTypeDeleted = "";

        DVD deleteDvd = searchDVD.where().eq("w1698510_isbn",TypeIsbn).findUnique();
        Book deleteBook = searchBook.where().eq("w1698510_isbn",TypeIsbn).findUnique();

        if(deleteBook != null){
            Ebean.delete(deleteBook);
            itemTypeDeleted = "Book";
        }else if(deleteDvd != null){
            Ebean.delete(deleteDvd);
            itemTypeDeleted = "DVD";
        }

        int countOfBooks = searchBook.findRowCount();
        int countOfDVDs = searchDVD.findRowCount();

        int slotsLeft = 150 - (countOfBooks + countOfDVDs);
        deleteItemsDTO = new DeleteItemsDTO(slotsLeft,itemTypeDeleted);
        return deleteItemsDTO;
    }

    @Override
    public ArrayList<DisplayAllItemDTO> DisplayAllItems() {

        ArrayList<DisplayAllItemDTO> displayAllItemDTOS = new ArrayList<>();

        List<Book> allAddedBooks = searchBook.findList();
        List<DVD> allAddedDVDs = searchDVD.findList();

        for (Book bks : allAddedBooks){

            String bookTitle = bks.getW1698510_title();
            String bookType = "Book";
            String bookISBN = bks.getW1698510_isbn();

            displayAllItemDTOS.add(new DisplayAllItemDTO(bookISBN,bookTitle,bookType));
        }

        for(DVD dvd : allAddedDVDs){

            String dvdTitle = dvd.getW1698510_title();
            String dvdType = "DVD";
            String dvdISBN = dvd.getW1698510_isbn();

            displayAllItemDTOS.add(new DisplayAllItemDTO(dvdISBN,dvdTitle,dvdType));
        }

        return displayAllItemDTOS;

    }

    @Override
    public String borrowNewItem(BorrowNewItemDTO borrowNewItemDTO) {

        String date_Returned;

        String DateBorrowed = borrowNewItemDTO.getBorrow_date().getYear() + "/" + borrowNewItemDTO.getBorrow_date().getMonth()
                + "/" + borrowNewItemDTO.getBorrow_date().getDay() + " " + borrowNewItemDTO.getBorrow_date().getHrs()
                + ":" + borrowNewItemDTO.getBorrow_date().getMins();
        String DateReturned = borrowNewItemDTO.getReturn_date().getYear() + "/" + borrowNewItemDTO.getReturn_date().getMonth()
                + "/" + borrowNewItemDTO.getReturn_date().getDay() + " " + borrowNewItemDTO.getReturn_date().getHrs() + ":"
                + borrowNewItemDTO.getReturn_date().getMins();


        ItemsBorrowed brwHistory = new ItemsBorrowed(borrowNewItemDTO.getUserId(), borrowNewItemDTO.getUsername(), borrowNewItemDTO.getContactNo(),
                borrowNewItemDTO.getUserEmail(),
                DateBorrowed, DateReturned, borrowNewItemDTO.getIsbn(), borrowNewItemDTO.isItemType(),false,"");


        ItemsBorrowed itemsBorrowedCheck = searchBorrowHistory.where().eq("w1698510_isbn", borrowNewItemDTO.getIsbn()).eq("w1698510_isReturned",
                false).findUnique();

        if(itemsBorrowedCheck != null){
            date_Returned = itemsBorrowedCheck.getW1698510_return_Date();
        }else {
            Ebean.save(brwHistory);
            date_Returned = "null";
        }

        return date_Returned;
    }

    @Override
    public String ReturnAnItem(String typeIsbn) {

        String totalValue;

        ItemsBorrowed returned_itemsBorrowed = searchBorrowHistory.where().eq("w1698510_isbn",typeIsbn).eq("w1698510_isReturned",
                false).findUnique();


        Date date1 = new Date();
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        try {
            Date date_returned = dFormat.parse(returned_itemsBorrowed.getW1698510_return_Date());

            if(!date1.before(date_returned)){

                Period datePeriod = new Period(date1.getTime(), date_returned.getTime());
                int extraHrs = datePeriod.getHours();

                    int day_Gaps =  date1.getDay() - date_returned.getDay();

                    if(day_Gaps > 3){
                        double temporaryAmount = 0.5 * extraHrs;
                        totalValue = String.valueOf(temporaryAmount);
                    }else {
                        double temporaryAmount = 0.2 * extraHrs;
                        totalValue = String.valueOf(temporaryAmount);
                    }


            }else {
                totalValue = "null";
            }

            returned_itemsBorrowed.setW1698510_isReturned(true);
            returned_itemsBorrowed.setW1698510_itemAmount(totalValue);

            Ebean.update(returned_itemsBorrowed);

        } catch (ParseException e) {

            e.printStackTrace();
            totalValue = "null";
        }


        return totalValue;
    }

    @Override
    public ArrayList<ItemsBorrowed> reportGeneration() {

        List<ItemsBorrowed> temporaryReport_data = searchBorrowHistory.all();

        ArrayList<ItemsBorrowed> dataReport = new ArrayList<>(temporaryReport_data);

        return dataReport;
    }
}
