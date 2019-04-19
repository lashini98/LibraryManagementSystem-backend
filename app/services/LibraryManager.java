package services;

import DTO.*;
import models.ItemsBorrowed;

import java.util.ArrayList;

public interface LibraryManager {

     ItemCountDTO addItems();

     boolean saveNewItem(AddNewItemDTO addNewItemDTO);

     DeleteItemsDTO deleteAnItem(String ISBN);

     ArrayList<DisplayAllItemDTO> DisplayAllItems();

     String borrowNewItem(BorrowNewItemDTO borrowNewItemDTO);

     String ReturnAnItem(String ISBN);

     ArrayList<ItemsBorrowed> reportGeneration();

}
