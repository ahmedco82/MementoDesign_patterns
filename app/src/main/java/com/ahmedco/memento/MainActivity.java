package com.ahmedco.memento;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmedco.memento.test1.Caretaker;
//import com.ahmedco.memento.test1.Originator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Test1();
        Test2();
    }

    private void Test2() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }


    private void Test1(){
        // https://sourcemaking.com/design_patterns/memento
        /*
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento(originator.save());
        originator.setState("State3");
        caretaker.addMemento(originator.save() );
        originator.setState("State4");
        originator.restore( caretaker.getMemento() );
        */
    }
}
