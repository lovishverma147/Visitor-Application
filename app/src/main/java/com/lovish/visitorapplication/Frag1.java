package com.lovish.visitorapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Frag1 extends Fragment {

    private TextInputLayout tv_sched_dnt;
    private LinearLayout ll_schedule, schedule, ll_actual;
    private EditText et_schedule, et_time;
    private Animation animation;
    private Button Submit;
    FloatingActionButton floatingActionButton;
    private Animation anim;
    private String ampm;

    private ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    private RecyclerView recyclerView;

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.carrier_signin, container, false);


        schedule = v.findViewById(R.id.schedule);
        floatingActionButton = v.findViewById(R.id.fab);
        Submit = v.findViewById(R.id.submit);
        ll_schedule = v.findViewById(R.id.ll_schedule);
        ll_actual = v.findViewById(R.id.ll_actual);
        et_time = v.findViewById(R.id.et_time);
        recyclerView = v.findViewById(R.id.rv);
        et_schedule = v.findViewById(R.id.et_schedule);
        tv_sched_dnt = v.findViewById(R.id.tv_sched_dnt);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.left_swipper);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.right_swipper);
        System.out.println("animate");


       /* floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intient = new Intent(getContext(),Frag3.class);
                startActivity(intient);
            }
        });*/


        /*arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getContext(),R.layout.carrier_list,arrayList);
        recyclerView.setAdapter(adapter);*/

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        et_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Objects.requireNonNull(getContext()),android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener,year,month,day);
                Objects.requireNonNull(datePickerDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = day+"/"+month+"/"+year;
                et_schedule.setText(date);
            }
        };

        et_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                final int minuts = calendar.get(Calendar.MINUTE);
                final TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint({"DefaultLocale", "SetTextI18n"})
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hoursOfDay, int minutes) {
                        if (hoursOfDay >= 12) {
                            ampm = "PM";
                        } else {
                            ampm = "AM";
                        }
                        et_time.setText(String.format("%02d:%02d", hoursOfDay, minutes) + ampm);
                    }
                },hour,minuts,true);
                Objects.requireNonNull(timePickerDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.show();
            }
        });




        return v;
    }


    /* public void onButtonClick() {
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date = et_schedule.getText().toString();
                arrayList.add(Date);
            }
        });
    }*/

   /* @Override
    public void onStart() {
        super.onStart();
        animate();
    }*/

    /*private void animate() {*/
       /* ll_schedule.setAnimation(anim);
        anim.start();

        schedule.setAnimation(animation);
        animation.setStartTime(2000);
        animation.setDuration(2000);
        animation.start();

        et_schedule.setAnimation(animation);

        tv_sched_dnt.setAnimation(animation);
        animation.setStartTime(2000);
        animation.setDuration(2000);
        animation.start();

        ll_actual.setAnimation(anim);
        anim.start();*/

}
