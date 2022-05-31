package ui.swagger.extractionResponseData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ExtractionResponseData {

    static ValidatableResponse response;

    @BeforeClass

    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }
    //01.Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("limit : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    //02. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //03.Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //04.Extract the names of all the store
    @Test
    public void test004() {
        ArrayList<String> listOfNames = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the names of all the store = " + listOfNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //05.Extract the storeId of all the store
    @Test
    public void test005() {

        List<Integer> listOfStoreIds = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storeId of all the store = " + listOfStoreIds);
        System.out.println("------------------End of Test---------------------------");
    }

    //06.Print the size of the data list
    @Test
    public void test006() {
        List<Integer> dataList = response.extract().path("data.length");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the size of the data list = " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //07.Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the value of the store where store name = St Cloud = " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //08.Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> list = response.extract().path("data.findAll{it.name=='Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the address of the store where store name = Rochester = " + list);
        System.out.println("------------------End of Test---------------------------");
    }

    //09.Get all the services of 8th store
    @Test
    public void test009() {
        List<Object> services = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the services of 8th store = " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10.Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        // List<Object> storeServices = response.extract().path("data.findAll{it.services.name=='Windows Store'}");
       // List<HashMap<String, ?>> storeServices = response.extract().path("data.services.findAll{it.name=='Windows Store'}.storeservices");
      List<?> storeServices1 = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("storeservices of the store where service name = Windows Store = " + storeServices1);
        System.out.println("------------------End of Test---------------------------");
    }

    //11.Get all the storeId of all the store
    @Test
    public void test011() {

        List<?> storeId = response.extract().path("data.services.storeservices.findAll{it.storeId}.storeId");
        Iterator<?> itr = storeId.iterator();
        while (itr.hasNext()) {
            // System.out.println(itr.next());
            List<?> check = (List<?>) itr.next();
            System.out.println("List of name of all stores id are : " + check.get(0));
        }
    }
        //12. Get id of all the store
        @Test
        public void test012 () {
            List<?> id = response.extract().path("data.services.id");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Get id of all the store = " + id);
            System.out.println("------------------End of Test---------------------------");
        }
        //13. Find the store names Where state = ND
        @Test
        public void test013 () {
            List<String> names = response.extract().path("data.findAll{it.state =='ND'}.name");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Find the store names Where state = ND = " + names);
            System.out.println("------------------End of Test---------------------------");
        }
        //14.Find the Total number of services for the store where store name = Rochester
        @Test
        public void test014 () {
        List<?>noOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.services.find{it.name}");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("the Total number of services for the store where store name = Rochester = " + noOfServices.size());
            System.out.println("------------------End of Test---------------------------");
        }
        //15. Find the createdAt for all services whose name = “Windows Store”
        @Test
        public void test015 () {
           List<?> createdAt = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.createdAt");

            System.out.println("------------------StartingTest---------------------------");
           System.out.println("the createdAt for all services whose name = “Windows Store” = " + createdAt);
            System.out.println("------------------End of Test---------------------------");
        }
        //16. Find the name of all services Where store name = “Fargo”
        @Test
        public void test016 () {
        List<String> names = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Find the name of all services Where store name = “Fargo” = " + names);
            System.out.println("------------------End of Test---------------------------");
        }
        //17. Find the zip of all the store
        @Test
        public void test017 () {
        List<Integer> zipList = response.extract().path("data.zip");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("the zip of all the store = " + zipList);
            System.out.println("------------------End of Test---------------------------");
        }
        //18. Find the zip of store name = Roseville
        @Test
        public void test018 () {
        List<Integer> zipList = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("the zip of store name = Roseville : " + zipList);
            System.out.println("------------------End of Test---------------------------");
        }
        //19. Find the storeservices details of the service name = Magnolia Home Theate
        @Test
        public void test019 () {
        List<HashMap<String,?>> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("the storeservices details of the service name = Magnolia Home Theatre" + storeServices);
            System.out.println("------------------End of Test---------------------------");
        }
        //20. Find the lat of all the stores
        @Test
        public void test020 () {
        List<Integer> latList = response.extract().path("data.lat");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("the zip of store name = Roseville : " + latList);
            System.out.println("------------------End of Test---------------------------");
        }
    }





