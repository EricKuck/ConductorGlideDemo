package com.erickuck.conductorglidedemo;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluelinelabs.conductor.Controller;

public class HomeController extends Controller {

    @NonNull @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);

        ImageView imageView1 = view.findViewById(R.id.imageView1);

        ControllerRequestManager.with(this).load("http://goo.gl/gEgYUd").into(imageView1);

        return view;
    }

}
