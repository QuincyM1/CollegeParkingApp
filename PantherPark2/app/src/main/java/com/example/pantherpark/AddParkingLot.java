package com.example.pantherpark;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pantherpark.data_objects.AdminUser;

public class AddParkingLot extends AppCompatActivity {

    private EditText etName, etAddress, etCity, etState, etZip, etLotStatus;
    // Create an instance of the AdminUser class
    private AdminUser adminUser = new AdminUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parking_lot);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        etLotStatus = findViewById(R.id.etLotStatus);

        Button btnAddParkingLot = findViewById(R.id.btnAddParkingLot);

        btnAddParkingLot.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String address = etAddress.getText().toString();
            String city = etCity.getText().toString();
            String state = etState.getText().toString();
            int zip = Integer.parseInt(etZip.getText().toString());
            String lotStatus = etLotStatus.getText().toString();
            boolean lotAvailable = lotStatus.equalsIgnoreCase("Open");

            // Assuming you have an instance of AdminUser named adminUser

            adminUser.addParkingLot(name, address, city, state, zip, lotStatus, lotAvailable);
        });
    }
}
