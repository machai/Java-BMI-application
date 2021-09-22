package com.example.bmicalculator;

/*Machai Bulawayo Assgnment1
 * student number = 54651719
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


//Main activity class start here
public class MainActivity extends Activity {

//Define layout
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

//Get the references to the widgets
final EditText e1 = (EditText) findViewById(R.id.et1);
final EditText e2 = (EditText) findViewById(R.id.et2);
final TextView tv4 = (TextView) findViewById(R.id.tv4);

findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

//Logic for validation, input can't be empty
@Override
public void onClick(View v) {

String str1 = e1.getText().toString();
String str2 = e2.getText().toString();

if(TextUtils.isEmpty(str1)){
e1.setError("Please enter your weight");
e1.requestFocus();
return;
}

if(TextUtils.isEmpty(str2)){
e2.setError("Please enter your height");
e2.requestFocus();
return;
}

//Get the user values from the widget reference
float weight = Float.parseFloat(str1);
float height = Float.parseFloat(str2)/100;

//Calculate BMI value
float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
String bmiInterpretation = interpretBMI(bmiValue);

tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

}
});

}

//Calculate BMI
private float calculateBMI (float weight, float height) {
return (float) (weight / (height * height));
}

//Interpret what BMI means
private String interpretBMI(float bmiValue) {

if (bmiValue < 16) {
return "Severely underweight";
} else if (bmiValue < 18.5) {

return "Underweight";
} else if (bmiValue < 25) {

return "Normal";
} else if (bmiValue < 30) {

return "Overweight";
} else {
return "Obese";
}
}
}