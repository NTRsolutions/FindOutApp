package com.project.verbosetech.findout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.project.verbosetech.findout.other.KeyboardUtil;
import com.project.verbosetech.findout.R;

/**
 * Created by this pc on 08-06-17.
 */

public class ProfileFragment extends Fragment {
    private EditText email, name, phone;

    private KeyboardUtil keyboardUtil;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_save:
                if (item.getTitle().toString().equalsIgnoreCase("edit")) {
                    name.setInputType(InputType.TYPE_CLASS_TEXT);
                    phone.setInputType(InputType.TYPE_CLASS_PHONE);
                    email.setInputType(InputType.TYPE_CLASS_TEXT);
                    name.requestFocus();
                    keyboardUtil.openKeyboard();
                    item.setTitle("Save");
                } else {
                    name.setInputType(InputType.TYPE_NULL);
                    phone.setInputType(InputType.TYPE_NULL);
                    email.setInputType(InputType.TYPE_NULL);
                    keyboardUtil.closeKeyboard();
                    item.setTitle("Edit");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        email = (EditText) view.findViewById(R.id.email);
        name = (EditText) view.findViewById(R.id.name);
        phone = (EditText) view.findViewById(R.id.number);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email.setInputType(InputType.TYPE_NULL);
        name.setInputType(InputType.TYPE_NULL);
        phone.setInputType(InputType.TYPE_NULL);

        keyboardUtil = KeyboardUtil.getInstance(getActivity());
    }
}
