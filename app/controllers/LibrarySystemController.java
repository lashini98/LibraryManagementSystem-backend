package controllers;

import DTO.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ItemsBorrowed;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;

import javax.inject.Inject;
import java.util.ArrayList;

public class LibrarySystemController extends Controller {

    @Inject
    private LibraryManager libraryManager;

    @Inject
    private ObjectMapper objectMapper;


    public Result DeleteItem(String isbn){

        DeleteItemsDTO deleteItemsDTO = libraryManager.deleteAnItem(isbn);

        return ok(Json.toJson(deleteItemsDTO));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result SaveItem(){

        JsonNode jsonNode = request().body().asJson();

        AddNewItemDTO addNewItemDTO = null;

        try {
            addNewItemDTO = objectMapper.treeToValue(jsonNode, AddNewItemDTO.class);


            boolean isSuccess = libraryManager.saveNewItem(addNewItemDTO);

            return ok(Json.toJson(isSuccess));

        }catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest("Not Json" , e.getMessage());
        }

    }

    public Result DisplayItems(){

        ArrayList<DisplayAllItemDTO> itemDTOList = libraryManager.DisplayAllItems();

        return ok(Json.toJson(itemDTOList));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result BorrowItem(){

        JsonNode jsonNode = request().body().asJson();

        BorrowNewItemDTO borrowHistory = null;

        try {
            borrowHistory = objectMapper.treeToValue(jsonNode, BorrowNewItemDTO.class);


            String date = libraryManager.borrowNewItem(borrowHistory);

            return ok(Json.toJson(date));

        }catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest("Not Json" , e.getMessage());
        }
    }

    public Result AvailableSlots(){

        ItemCountDTO countItemsDTO = libraryManager.addItems();

        return ok(Json.toJson(countItemsDTO));
    }


    public Result ReturnItem(String isbn){

        String amount = libraryManager.ReturnAnItem(isbn);


        return ok(Json.toJson(amount));
    }


    public Result GenereateReport(){

        ArrayList<ItemsBorrowed> borrowHistories = libraryManager.reportGeneration();

        return ok(Json.toJson(borrowHistories));
    }
}
