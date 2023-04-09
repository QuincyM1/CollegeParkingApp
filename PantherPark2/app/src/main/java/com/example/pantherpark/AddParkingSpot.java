package com.example.pantherpark;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pantherpark.data_objects.AdminUser;

public class AddParkingSpot extends AppCompatActivity {

    private EditText etSpotNumber, etParkingLotId, etReservationStatus;

    // Create an instance of the AdminUser class
    private AdminUser adminUser = new AdminUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parking_spot);

        etSpotNumber = findViewById(R.id.spot_code_input);
        etParkingLotId = findViewById(R.id.deck_id_input);
        etReservationStatus = findViewById(R.id.reservation_status_input);
        Button btnSubmit = findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(v -> {
            int spotNumber = Integer.parseInt(etSpotNumber.getText().toString());
            String parkingLotId = etParkingLotId.getText().toString();
            String reservationStatusText = etReservationStatus.getText().toString();
            boolean spotAvailable = reservationStatusText.equals("Open");

            adminUser.addParkingSpot(spotNumber, parkingLotId, reservationStatusText, spotAvailable);
        });
    }
}
