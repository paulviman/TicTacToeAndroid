package com.example.proiectfinalandroid;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    static boolean PLAYER_X = true;
    static int TURN_COUNT = 0;
    boolean stopRandom = false;

    static Button b00;
    static Button b01;
    static Button b02;

    static Button b10;
    static Button b11;
    static Button b12;

    static Button b20;
    static Button b21;
    static Button b22;

    TextView tvTime;

    Button bReset;
    Button bBack;
    int mode;

    static TextView tvInfo;

    static int[][] boardStatus = new int[3][3];
    Button[][] buttonStatus;
    Handler handler = new Handler();
    Thread threadTimer = new MyThread();

    boolean winner = false;
    int timer;
    boolean threadOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        mode = Integer.parseInt(intent.getStringExtra("mode"));
        tvTime = findViewById(R.id.tvTime);

        b00 = findViewById(R.id.b00);
        b01 = findViewById(R.id.b01);
        b02 = findViewById(R.id.b02);

        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);

        b20 = findViewById(R.id.b20);
        b21 = findViewById(R.id.b21);
        b22 = findViewById(R.id.b22);

        bReset = findViewById(R.id.bReset);
        bBack = findViewById(R.id.bBack);
        tvInfo = findViewById(R.id.tvInfo);

        bReset.setOnClickListener(this);
        bBack.setOnClickListener(this);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        initializeBoardStatus();
        buttonStatus = new Button[][]{{b00, b01, b02}, {b10, b11, b12}, {b20, b21, b22}};
        timer = 0;

        threadTimer.start();

    }

    public class MyThread extends Thread implements Runnable {
        public void run() {
            if (threadOn) {
                while (!winner) {
                    timer++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tvTime.setText(timer + " seconds");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        //Log.d(TAG, "Inside onClick");

        boolean resetButtonPressed = false;

        switch (view.getId()) {
            case R.id.b00:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b00.setText("X");
                        boardStatus[0][0] = 1;
                    } else {
                        b00.setText("0");
                        boardStatus[0][0] = 0;
                    }
                } else if (PLAYER_X) {
                    b00.setText("X");
                    boardStatus[0][0] = 1;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b01.setText("X");
                        boardStatus[0][1] = 1;
                    } else {
                        b01.setText("0");
                        boardStatus[0][1] = 0;
                    }
                } else if (PLAYER_X) {
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b02.setText("X");
                        boardStatus[0][2] = 1;
                    } else {
                        b02.setText("0");
                        boardStatus[0][2] = 0;
                    }
                } else if (PLAYER_X) {
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b10.setText("X");
                        boardStatus[1][0] = 1;
                    } else {
                        b10.setText("0");
                        boardStatus[1][0] = 0;
                    }
                } else if (PLAYER_X) {
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b11.setText("X");
                        boardStatus[1][1] = 1;
                    } else {
                        b11.setText("0");
                        boardStatus[1][1] = 0;
                    }
                } else if (PLAYER_X) {
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b12.setText("X");
                        boardStatus[1][2] = 1;
                    } else {
                        b12.setText("0");
                        boardStatus[1][2] = 0;
                    }
                } else if (PLAYER_X) {
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b20.setText("X");
                        boardStatus[2][0] = 1;
                    } else {
                        b20.setText("0");
                        boardStatus[2][0] = 0;
                    }
                } else if (PLAYER_X) {
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b21.setText("X");
                        boardStatus[2][1] = 1;
                    } else {
                        b21.setText("0");
                        boardStatus[2][1] = 0;
                    }
                } else if (PLAYER_X) {
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (mode == 1) {
                    if (PLAYER_X) {
                        b22.setText("X");
                        boardStatus[2][2] = 1;
                    } else {
                        b22.setText("0");
                        boardStatus[2][2] = 0;
                    }
                } else if (PLAYER_X) {
                    b22.setText("X");
                    boardStatus[2][2] = 1;
                }
                b22.setEnabled(false);
                break;

            case R.id.bReset:
                resetButtonPressed = true;
                winner = false;
                timer = 0;
                TURN_COUNT = 0;
                threadTimer = new MyThread();
                threadTimer.start();
                break;

            case R.id.bBack:
                stopRandom = true;
                PLAYER_X = false;
                enableAllBoxes(false);
                TURN_COUNT = -1;
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Back to menu...", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        if ((mode == 0)) {
            generateRandomCPU();

        }
        if (resetButtonPressed) {
            Toast.makeText(this, "The board has been reset. ", Toast.LENGTH_SHORT).show();
            resetBoard();
        } else {
            TURN_COUNT++;
            PLAYER_X = !PLAYER_X;
            System.out.println("Nr de apasari:" + TURN_COUNT);

            if (PLAYER_X) {
                setInfo("Player X turn");
            } else {
                setInfo("Player 0 turn");
            }

            if (TURN_COUNT == 9) {
                result("Game Draw");
                winner = true;
            }
            System.out.println("player curent " + PLAYER_X);
            checkWinner();

        }
    }

    private void generateRandomCPU() {
        int validareBucla = 0;
        if (!stopRandom) {
            // trebe sa aleg o pozitie random
            Random random = new Random();
            int randomI = random.nextInt(3);
            int randomJ = random.nextInt(3);
            System.out.println(randomI + " " + randomJ);
            // trebe sa verific daca pozitia nu ii ocupata
            while ((boardStatus[randomI][randomJ] != -1) && (TURN_COUNT <= 9) && (validareBucla < 15)) {
                // daca ii ocupata sa aleg alta pozitie random
                randomI = random.nextInt(3);
                randomJ = random.nextInt(3);
                System.out.println("Valoare aleasa acum:" + randomI + randomJ);
                validareBucla++;
            }
            //if (boardStatus[randomI][randomJ] == -1) {

            // daca pozitia ii liberaq sa setez valoarea pt cpu adica 0
            if (buttonStatus[randomI][randomJ].isEnabled()) {
                buttonStatus[randomI][randomJ].setText("0");
                boardStatus[randomI][randomJ] = 0;
                buttonStatus[randomI][randomJ].setEnabled(false);
                TURN_COUNT++;
                PLAYER_X = !PLAYER_X;

            }

        }


    }

    private void checkWinner() {

        Log.d(TAG, "Inside checkWinner");

        //Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    result("Player X winner\n" + (i + 1) + " row");
                    enableAllBoxes(false);
                    winner = true;
                    //threadOn = true;
                    break;
                } else if (boardStatus[i][0] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " row");
                    enableAllBoxes(false);
                    winner = true;
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    result("Player X winner\n" + (i + 1) + " column");
                    enableAllBoxes(false);
                    winner = true;
                    break;
                } else if (boardStatus[0][i] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " column");
                    enableAllBoxes(false);
                    winner = true;
                    break;
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                result("Player X winner\nFirst Diagonal");
                enableAllBoxes(false);
                winner = true;
            } else if (boardStatus[0][0] == 0) {
                result("Player 0 winner\nFirst Diagonal");
                enableAllBoxes(false);
                winner = true;

            }
        }

        //Second diagonal
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                result("Player X winner\nSecond Diagonal");
                enableAllBoxes(false);
                winner = true;
            } else if (boardStatus[0][2] == 0) {
                result("Player 0 winner\nSecond Diagonal");
                enableAllBoxes(false);

                winner = true;
            }
        }
    }

    private static void enableAllBoxes(boolean value) {
        Log.d(TAG, "Inside enableAllBoxes");
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);

        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);

        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }

    private void result(String winner) {
        Log.d(TAG, "Inside result");

        setInfo(winner);
        enableAllBoxes(false);
    }

    private void resetBoard() {
        Log.d(TAG, "Inside resetBoard");
        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Start Again!!!");

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private static void setInfo(String text) {
        tvInfo.setText(text);
    }

    private static void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }

    }
}