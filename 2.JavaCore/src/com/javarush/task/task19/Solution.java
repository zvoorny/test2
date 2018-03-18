package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
            while (reader1.ready()) {
                String firstFile = reader1.readLine();

                list1.add(firstFile);

            }
        while (reader2.ready()) {

            String seccondFile = reader2.readLine();

            list2.add(seccondFile);
        }
            reader.close();
            reader1.close();
            reader2.close();


            for (int i = 0; i < list1.size()||i<list2.size(); i++) {
                try{
                if (list1.get(i).equals(list2.get(i))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                } else if (list1.get(i).equals(list2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    list1.add(i, "");
                } else if ((!list1.get(i).equals(list2.get(i))) && (!list1.get(i).equals(list2.get(i + 1)))) {
                    list2.add(0, "");
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                }
            }catch (IndexOutOfBoundsException e){
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                }


            }
        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type + " " + lineItem.line);
        }

        }





    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
