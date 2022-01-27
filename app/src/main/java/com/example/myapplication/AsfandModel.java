package com.example.myapplication;

import java.util.ArrayList;

public class AsfandModel {

//    String ID,Name,Phone,Address;

    ArrayList<data> data;

    public ArrayList<AsfandModel.data> getData() {
        return data;
    }

    public void setData(ArrayList<AsfandModel.data> data) {
        this.data = data;
    }

    public class data {
        String id;
        String name;
        String phone;
        String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }


}
