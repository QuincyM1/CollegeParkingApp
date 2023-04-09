package com.example.pantherpark;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pantherpark.data_objects.AdminUser;

public class DeleteParkingSpot extends AppCompatActivity {

    private EditText etParkingLotId, etSpotNumber;

    // Create an instance of the AdminUser class
    private AdminUser adminUser = new AdminUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_parking_spot);

        etParkingLotId = findViewById(R.id.parking_lot_id_input);
        etSpotNumber = findViewById(R.id.spot_number_input);
        Button btnDelete = findViewById(R.id.delete_button);
        btnDelete.setOnClickListener(v -> {
            String parkingLotId = etParkingLotId.getText().toString();
            int spotNumber = Integer.parseInt(etSpotNumber.getText().toString());

            adminUser.deleteParkingSpot(parkingLotId, spotNumber);
        });
    }
}
