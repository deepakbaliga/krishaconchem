package com.deepakbaliga.krishnaconchem;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends DialogFragment {

    private LinearLayout address, telephone, email, website;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contact_us, container, false);
        address = (LinearLayout) view.findViewById(R.id.ll_address);
        telephone = (LinearLayout) view.findViewById(R.id.ll_telephone);
        email = (LinearLayout) view.findViewById(R.id.ll_email);
        website = (LinearLayout) view.findViewById(R.id.ll_website);


        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String uri = "https://www.google.co.in/maps/place/Krishna+Conchem+Products+Pvt+Ltd/@18.9864496,72.8435131,15z/data=!4m2!3m1!1s0x0:0x9143b8da3f2c73fd";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getActivity().startActivity(intent);
            }
        });

        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+912227782923"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","info@krishnaconchem.com", null));

                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://krishnaconchem.com/Default.aspx";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });




        return view;
    }

}
