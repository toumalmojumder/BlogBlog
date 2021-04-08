package com.toumal.blogblog.Fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.toumal.blogblog.Data.RBlog;
import com.toumal.blogblog.R;
import com.toumal.blogblog.RBlogViewModel;

public class AddFragment extends Fragment {
private RBlogViewModel rBlogViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_add, container, false);
        TextInputLayout title,description,name,avatar,profession;
        CheckBox checkBoxOne,checkBoxTwo,checkBoxThree,checkBoxFour;

        Button button;
        title = view.findViewById(R.id.Title_ED);
        description = view.findViewById(R.id.description_ED);

        checkBoxOne=view.findViewById(R.id.categories_one);
        checkBoxTwo=view.findViewById(R.id.categories_two);
        checkBoxThree=view.findViewById(R.id.categories_three);
        checkBoxFour=view.findViewById(R.id.categories_four);

        name = view.findViewById(R.id.name_ED);
        avatar = view.findViewById(R.id.avatar_ED);
        profession = view.findViewById(R.id.profession_ED);
        button = view.findViewById(R.id.addToRoomButton);

        rBlogViewModel = new ViewModelProvider(this).get(RBlogViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleST = title.getEditText().getText().toString();
                String  descriptionST =description.getEditText().getText().toString();

                String categoriesOne = (checkBoxOne.isChecked())? checkBoxOne.getText().toString():" ";
                String categoriesTwo = (checkBoxTwo.isChecked())? checkBoxTwo.getText().toString():" ";
                String categoriesThree = (checkBoxThree.isChecked())? checkBoxThree.getText().toString():" ";
                String categoriesFour = (checkBoxFour.isChecked())? checkBoxFour.getText().toString():" ";
                String categoriesST = categoriesOne+" "+categoriesTwo+" "+categoriesThree+" "+categoriesFour;
                String nameST =name.getEditText().getText().toString();
                String  avatarST = avatar.getEditText().getText().toString();
                String professionST=profession.getEditText().getText().toString();

                RBlog rBlog = new RBlog(0,titleST,descriptionST,null,categoriesST,nameST,avatarST,professionST);
               if (title!=null){
                   rBlogViewModel.addRBlog(rBlog);
                   Navigation.findNavController(requireView()).navigate(R.id.action_addFragment_to_listFragment);
               }
            }
        });
        return view;
    }
}