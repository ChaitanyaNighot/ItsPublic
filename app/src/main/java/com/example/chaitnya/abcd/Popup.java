package com.example.chaitnya.abcd;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Popup extends Activity {
    private String HALFFEE = "Halffee";
    private String FULLFE = "Fullfee";
    int valueFull=0;
    int valueHalf=0;
    private String MENUITEMNAME = "MenuItemName";
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private String halffee,fullfee,menuitem;
    Button save,fulladd,fullsub,halfadd,halfsub;
    TextView menuitemtxt,full,half,fullfeetxt,halffeetxt,halftxt,fulltxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        save = (Button)findViewById(R.id.popup_qty_save);
        fulladd = (Button)findViewById(R.id.full_add);
        fullsub=(Button)findViewById(R.id.full_sub);

        halfadd=(Button)findViewById(R.id.half_add);
        halfsub =(Button)findViewById(R.id.half_sub);

        menuitemtxt=(TextView)findViewById(R.id.menuitem);

        full=(TextView)findViewById(R.id.Full);
        fullfeetxt=(TextView)findViewById(R.id.fee_full);
        fulltxt=(TextView)findViewById(R.id.full_txt);
        fulltxt.setText("0");

        half=(TextView)findViewById(R.id.half);
        halffeetxt=(TextView)findViewById(R.id.fee_half);
        halftxt=(TextView)findViewById(R.id.half_txt);
        halftxt.setText("0");


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout( (int)(width*.75) , (int)(height*.45));
       Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);
        halffee=extras.getString(HALFFEE);
        fullfee=extras.getString(FULLFE);
        menuitem=extras.getString(MENUITEMNAME);


        if(halffee.equals("0"))
        {   getWindow().setLayout( (int)(width*.75) , (int)(height*.35));
            half.setVisibility(View.INVISIBLE);
            halffeetxt.setVisibility(View.INVISIBLE);
            halftxt.setVisibility(View.INVISIBLE);
            menuitemtxt.setText(menuitem);
            fullfeetxt.setText(fullfee);
            halfadd.setVisibility(View.INVISIBLE);
            halfsub.setVisibility(View.INVISIBLE);
        }
        else
        {       getWindow().setLayout( (int)(width*.75) , (int)(height*.45));
            menuitemtxt.setText(menuitem);
            fullfeetxt.setText(fullfee);
            halffeetxt.setText(halffee);

        }

        fulladd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               valueFull = Integer.parseInt(fulltxt.getText().toString());
                if(valueFull>=0 && valueFull <=9)
                {
                    valueFull=valueFull+1;
                }
                else if(valueFull==10)
                {
                    valueFull=10;

                }

                fulltxt.setText(String.valueOf(valueFull));
            }
        });

        fullsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueFull= Integer.parseInt(fulltxt.getText().toString());
                if(valueFull>=1)
                {
                    valueFull=valueFull-1;
                }
                else if(valueFull==0)
                {
                    valueFull=0;
                }

                fulltxt.setText(String.valueOf(valueFull));
            }
        });



        halfadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueHalf = Integer.parseInt(halftxt.getText().toString());
                if(valueHalf>=0 && valueHalf <=9)
                {
                    valueHalf=valueHalf+1;
                }
                else if(valueHalf==10)
                {
                    valueHalf=10;

                }

                halftxt.setText(String.valueOf(valueHalf));


            }
        });

        halfsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valueHalf = Integer.parseInt(halftxt.getText().toString());
                if(valueHalf>=1)
                {
                    valueHalf=valueHalf-1;
                }
                else if(valueHalf==0)
                {
                    valueHalf=0;
                }

                halftxt.setText(String.valueOf(valueHalf));

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inserting database
                CartOrder cartOrder = new CartOrder("1",halftxt.getText().toString(),
                        fulltxt.getText().toString(),halffee,fullfee);
                cartOrder.save();

                // reading database
                CartOrder cartOrder1 = CartOrder.findById(CartOrder.class,1L);
                Toast.makeText(getApplicationContext(),cartOrder1.pricehalf,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),cartOrder1.pricefull,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
