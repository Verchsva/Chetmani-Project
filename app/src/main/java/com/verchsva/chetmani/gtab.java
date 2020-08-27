package com.verchsva.chetmani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.verchsva.chetmani.gallery.GalleryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gtab extends Fragment {
    GridView gridView;


    @Override
    public View onCreateView(
            final LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


//        gridView=(GridView) root.findViewById(R.id.grid_view);
//        gridView.setAdapter(new ImageAdapter(getContext()));
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i=new Intent(getContext(),FullImageActivity.class);
//                i.putExtra("id",position);
//                startActivity(i);
//            }
//        });
        return inflater.inflate(R.layout.fragment_tab2home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView rvImages = getView().findViewById(R.id.rv_images);
        rvImages.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));
        final GalleryAdapter galleryAdapter = new GalleryAdapter();
        rvImages.setAdapter(galleryAdapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("IMAGES");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> strings = new ArrayList<>();
                int index = 1;
                while (snapshot.hasChild("" + index)) {
                    Object value = snapshot.child("" + index).getValue();
                    if (value != null) {
                        strings.add(value.toString());
                    }
                    index++;
                }
                galleryAdapter.addItems(strings);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        galleryAdapter.addItems(Arrays.asList(
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg",
//                "https://4.imimg.com/data4/KY/YH/MY-2550960/fine-gold-polish-jewellery-500x500.jpg"));
//    }
    }
}
