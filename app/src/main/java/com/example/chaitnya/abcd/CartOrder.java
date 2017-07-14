package com.example.chaitnya.abcd;

import android.content.Context;

import com.orm.SugarRecord;

/**
 * Created by CHAITNYA on 7/11/2017.
 */

public class CartOrder extends SugarRecord<CartOrder> {

    String itemid,qtyhalf,qtyfull,pricehalf,pricefull;

    public CartOrder ()
    {

    }

    public CartOrder(String itemid,String qtyhalf,String qtyfull,String pricehalf,String pricefull)
    {
        this.itemid=itemid;
        this.qtyhalf=qtyhalf;
        this.qtyfull=qtyfull;
        this.pricefull=pricefull;
        this.pricehalf=pricehalf;
    }

}
