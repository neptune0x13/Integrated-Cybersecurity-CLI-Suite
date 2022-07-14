package io.github.kunalattri.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button cut, parenthesis, modulo, divide, multiply, subtract, add, one, two, three,
    four, five, six, seven, eight, nine, dot, equalto, zero;
    private TextView current, result;
    private double previous, now;
    private String operator;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cut = findViewById(R.id.cut);
        parenthesis = findViewById(R.id.parenthesis);
        modulo = findViewById(R.id.modulo);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        subtract = findViewById(R.id.subtract);
        add = findViewById(R.id.add);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.decimal);
        equalto = findViewById(R.id.equalto);
        current = findViewById(R.id.current);
        result = findViewById(R.id.result);
        previous = 0;
        now = 0;
        operator = "";

        current.setText("");
        result.setText("");

        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = 0;
                previous = 0;
                result.setText("");
                current.setText("");
                operator = "";
                flag = false;
            }
        });

        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                flag = false;
                current.setText("");
                updateCurrent(String.valueOf(previous));
                result.setText("");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 1;
                flag = true;
                updateCurrent(one.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 2;
                flag = true;
                updateCurrent(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 3;
                flag = true;
                updateCurrent(three.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 4;
                flag = true;
                updateCurrent(four.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 5;
                flag = true;
                updateCurrent(five.getText().toString());
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 6;
                flag = true;
                updateCurrent(six.getText().toString());
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 7;
                flag = true;
                updateCurrent(seven.getText().toString());
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 8;
                flag = true;
                updateCurrent(eight.getText().toString());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 9;
                flag = true;
                updateCurrent(nine.getText().toString());
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                now = now * 10 + 0;
                flag = true;
                updateCurrent(zero.getText().toString());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    calculate();
                    updateResult();
                    operator = add.getText().toString();
                    flag = false;
                    updateCurrent(operator);
                } else if (previous != 0 && !current.getText().toString().isEmpty()){
                    operator = add.getText().toString();
                    if (!operator.isEmpty()) {
                        updateCurrent(operator, true);
                    } else {
                        updateCurrent(operator);
                    }
                } else  if (!operator.isEmpty()) {
                    operator = add.getText().toString();
                    updateCurrent(operator, true);
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    calculate();
                    updateResult();
                    operator = subtract.getText().toString();
                    flag = false;
                    updateCurrent(operator);
                } else if (previous != 0 && !current.getText().toString().isEmpty()){
                    operator = subtract.getText().toString();
                    if (!operator.isEmpty()) {
                        updateCurrent(operator, true);
                    } else {
                        updateCurrent(operator);
                    }
                } else  if (!operator.isEmpty()) {
                    operator = add.getText().toString();
                    updateCurrent(operator, true);
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    calculate();
                    updateResult();
                    operator = multiply.getText().toString();
                    flag = false;
                    updateCurrent(operator);
                } else if ((previous != 0 || now != 0) && operator.isEmpty()) {
                    operator = multiply.getText().toString();
                    updateCurrent(operator);
                } else if (previous != 0 || now != 0){
                    operator = multiply.getText().toString();
                    updateCurrent(operator, true);
                } else {
                        Toast.makeText(MainActivity.this, "Enter a no.", Toast.LENGTH_SHORT);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    calculate();
                    updateResult();
                    operator = divide.getText().toString();
                    flag = false;
                    updateCurrent(operator);
                } else if ((previous != 0 || now != 0)&& operator.isEmpty()) {
                    operator = divide.getText().toString();
                    updateCurrent(operator);
                } else if (previous != 0 || now != 0){
                    operator = divide.getText().toString();
                    updateCurrent(operator, true);
                } else {
                    Toast.makeText(MainActivity.this, "Enter a no.", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void updateResult() {
        result.setText(String.valueOf(previous));
    }

    private void updateCurrent(String next) {
        updateCurrent(next, false);
    }

    private void updateCurrent(String next, boolean change) {
        StringBuilder sb = new StringBuilder();
        sb.append(current.getText().toString());
        if (change) {
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append(next);
        current.setText(sb.toString());
    }

    private void calculate() {
        if (operator.isEmpty()) {
            previous = now;
            now = 0;
            updateResult();
        } else if (operator.equals("+")) {
            previous = previous + now;
            now = 0;
            updateResult();
        } else if (operator.equals("-")) {
            previous = previous - now;
            now = 0;
            updateResult();
        } else if (operator.equals("×")) {
            previous = previous * now;
            now = 0;
            updateResult();
        } else if (operator.equals("÷")) {
            previous = previous / now;
            now = 0;
            updateResult();
        }
        operator = "";
    }
}
