package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;





public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseProducts = FirebaseDatabase.getInstance().getReference("Products");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                products.clear();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                    Product product = postSnapshot.getValue(Product.class);
                    Products.add(product);

                }

                ProductList productAdapter = new ProductList(MainActivity.this,products);
                listViewProducts.setAdapter(productsAdapter);


            }

            private void addProduct(){
                String name = editTextName.getText().toString().trim();
                double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));

                if(!TextUtils.isEmpty(name)){
                    String id = databaseProducts.push().getKey();
                    Product product = new Product(id,name,price);
                    databaseProducts.child(id).setValue(product);
                    editTextName.setText("");
                    editTextPrice.setText("");

                    Toast.makeText(this,"Product added",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Please enter a name", Toast.LENGTH_LONG).show();
                }
            }

            private void updateProduct(String id, String name, double price){
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);
                Product product = new Product(id, name, price);
                dR.setValue(product);
                Toast.makeText(getApplicationContext(),"Product Updated", Toast.LENGTH_LONG).show();
            }

            private boolean deleteProduct(String id){
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);
                dR.removeValue();
                Toast.makeText(getApplicationContext(),"Product Deleted",Toast.LENGTH_LONG).show();
                return true;
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })
    }
}