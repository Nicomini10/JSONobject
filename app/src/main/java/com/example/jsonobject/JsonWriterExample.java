package com.example.jsonobject;

import android.util.JsonWriter;

import java.io.IOException;
import java.io.Writer;

public class JsonWriterExample {

    public static void writeJsonStream(Writer output, Company company)throws IOException{

        JsonWriter jsonWriter = new JsonWriter(output);

        jsonWriter.beginObject();

        jsonWriter.name("id").value(company.getId());
        jsonWriter.name("name").value(company.getName());

        String[] websites = company.getWebsites();

        jsonWriter.name("websites").beginArray();
        for(String website: websites){

            jsonWriter.value(website);
        }
        jsonWriter.endArray();

        jsonWriter.name("address").beginObject();
        jsonWriter.name("street").value(company.getAddress().getStreet());
        jsonWriter.name("city").value(company.getAddress().getCity());
        jsonWriter.endObject();

        jsonWriter.endObject();
    }

    public static Company createCompany(){
        Company company = new Company();
        company.setId(123);
        company.setName("Apple");

        String[] websites = {"http://apple.com", "http://jobs.apple.com"};
        company.setWebsites(websites);

        Address address = new Address();
        address.setCity("Cupertino");
        address.setStreet("1 Infinite Loop");

        company.setAddress(address);

        return company;

    }

}
