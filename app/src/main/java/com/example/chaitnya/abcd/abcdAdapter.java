package com.example.chaitnya.abcd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by CHAITNYA on 7/8/2017.
 */

public class abcdAdapter extends RecyclerView.Adapter<abcdAdapter.MyViewHolder>  {
    private LayoutInflater inflater;
    private String HALFFEE = "Halffee";
    private String FULLFE = "Fullfee";
    private String MENUITEMNAME = "MenuItemName";
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private Context mcontext;
    String[] name;
    String[] fee;
    int[] image;
    String[] halffee;
    String[] desc;
    Intent i;

    abcdAdapter(String[] name,String[] fee , int[] image,String[]  halffee,String[] desc,Context mcontext)
    {   inflater = LayoutInflater.from(mcontext);
        this.halffee=halffee;
        this.desc=desc;
        this.name =name;
        this.image=image;
        this.fee=fee;
        this.mcontext=mcontext;
    }


    public abcdAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cardview_paratha, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(name[position]);
        if(halffee[position].equals("0"))
        {
            holder.halffee.setVisibility(View.INVISIBLE);
        }else
        {
            holder.halffee.setText("/"+halffee[position]);
        }
        holder.description.setText(desc[position]);
        Glide.with(mcontext).load(image[position]).into(holder.imageView);
        holder.textView1.setText("Price : Rs "+fee[position]);



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                i = new Intent(mcontext,Popup.class);
                if(halffee[position].equals("0"))
                {
                    Toast.makeText(mcontext,"half",Toast.LENGTH_SHORT).show();
                    extras.putString(MENUITEMNAME,name[position]);
                    extras.putString(FULLFE,fee[position]);
                    extras.putString(HALFFEE,"0");


                }else
                {
                    Toast.makeText(mcontext,"half",Toast.LENGTH_SHORT).show();

                    extras.putString(MENUITEMNAME,name[position]);
                    extras.putString(HALFFEE,halffee[position]);
                    extras.putString(FULLFE,fee[position]);



                }
               i.putExtra(BUNDLE_EXTRAS,extras);

                mcontext.startActivity(i);
                Toast.makeText(mcontext,"you clicked "+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView halffee,description;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            imageView = (ImageView) itemView.findViewById(R.id.card_paratha);
            textView = (TextView)itemView.findViewById(R.id.cardparatha_name);
            halffee = (TextView)itemView.findViewById(R.id.cardparatha_half_fee);
            description=(TextView)itemView.findViewById(R.id.cardparatha_desc);
            textView1 = (TextView)itemView.findViewById(R.id.cardparatha_fee);
        }
    }
}
