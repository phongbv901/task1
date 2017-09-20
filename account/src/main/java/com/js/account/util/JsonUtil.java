package com.js.account.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.js.account.domain.Account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String FILE_PATH = "src/main/resources/data.json";
    public static List<Account> readData() {
        ArrayNode nodes = readFile();
        Iterator<JsonNode> elements = nodes.elements();
        List<Account> accounts = new ArrayList<>();
        while(elements.hasNext()){
            JsonNode accJson = elements.next();
            try {
                Account tmp = mapper.readValue(accJson.toString(), Account.class);
                accounts.add(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return accounts;
    }

    public static void saveData(List<Account> data) {
        try {
            mapper.writeValue(new File(FILE_PATH),data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayNode readFile() {
        try {
            //read json file data to String
            byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
            //read JSON like DOM Parser
            ArrayNode rootNode = (ArrayNode) mapper.readTree(jsonData);
            return rootNode;
        } catch (IOException e) {
            e.printStackTrace();
        }
      return null;
    }

}
