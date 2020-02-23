package com.triplepi.chyak_tutor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jmx.remote.internal.ArrayQueue;
import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.domain.Bank;
import com.triplepi.chyak_tutor.domain.Currency;
import com.triplepi.chyak_tutor.service.BankService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

//    public static void main(String[] args) {
//        BankService bankService = new BankService();
//        List<Account> accountList = new ArrayList<>();
//        Account account = new Account(1L, Currency.RUB, 10D);
//        Account account1 = new Account(2L, Currency.EUR, 10D);
//        Account account2 = new Account(3L, Currency.USD, 10D);
//        accountList.add(account);
//        accountList.add(account1);
//        accountList.add(account2);
//        Bank bank = new Bank(1L, "Без разницы", accountList);
//        bank.getAccountList().forEach(x -> bankService.deposit(x, 10D, x.getCurrency()));
//        for (Account x : bank.getAccountList()) {
//            System.out.println(x.toString());
//        }
//        System.out.println(bank.toString());
//        bankService.transfer(account, account1, 5D);
//        System.out.println("\n" + bank.toString());
////        Object
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input;
//        String doublePatternString = "-?\\d+(\\.\\d+)?";
//        String signPatternString = "[+\\-*/]";
//        Pattern doublePattern = Pattern.compile(doublePatternString);
//        Pattern signPattern = Pattern.compile(signPatternString);
//        Pattern expressionPattern = Pattern.compile(doublePatternString + signPatternString + doublePatternString);
//        while (true) {
//            input = scanner.nextLine();
//            if (input.equals("stop"))
//                return;
//            Matcher m = expressionPattern.matcher(input);
//            if (!m.matches()) {
//                System.out.println("Incorrect expression");
//                continue;
//            }
//            Matcher numberMatcher = doublePattern.matcher(input);
//            numberMatcher.find();
//            String aStr = numberMatcher.group();
//            numberMatcher.find();
//            String bStr = numberMatcher.group();
//            double a = Double.parseDouble(aStr);
//            double b = Double.parseDouble(bStr);
//            Matcher signMatcher = signPattern.matcher(input);
//            signMatcher.find();
//            char sign = signMatcher.group().charAt(0);
//            double result = 0;
//            switch (sign) {
//                case '+':
//                    result = a + b;
//                    break;
//                case '-':
//                    result = a - b;
//                    break;
//                case '*':
//                    result = a * b;
//                    break;
//                case '/':
//                    result = a / b;
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + sign);
//            }
//            System.out.println(result);
//        }
//    }

    //    public static void main(String[] args) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Bank bank = objectMapper.readValue(new FileInputStream(new File("src/main/resources/input.json"))
//                , Bank.class);
//        bank.getAccountList().remove(0);
//        objectMapper.writeValue(new File("src/main/resources/result.json"),bank);
//    }
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            entry.setValue(entry.getValue() + 1);
//            System.out.println(entry);
//        }
        map.forEach((x, y) -> y = y + 1);
        System.out.println(map);
    }
}
