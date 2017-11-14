package ravi.dagger.retrofit.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 310239754 on 11/10/2017.
 */

public class TestModel {

    @SerializedName("status")
    public String status;

    @SerializedName("message")
    public HashMap<String, ArrayList<String>> message;
}
