package hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelReservationSystem {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public HotelReservationSystem() {
        
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Deluxe"));

        
        JFrame frame = new JFrame("Hotel Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton viewRoomsButton = new JButton("View Available Rooms");
        JButton makeReservationButton = new JButton("Make a Reservation");
        JButton viewReservationsButton = new JButton("View Reservations");
        JButton exitButton = new JButton("Exit");

        panel.add(viewRoomsButton);
        panel.add(makeReservationButton);
        panel.add(viewReservationsButton);
        panel.add(exitButton);

        frame.add(panel);

    
        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder roomList = new StringBuilder("Available Rooms:\n\n");
                for (Room room : rooms) {
                    if (room.isAvailable) {
                        roomList.append(room.toString()).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(frame, roomList.toString(), "Available Rooms", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guestName = JOptionPane.showInputDialog(frame, "Enter your name:");
                if (guestName == null || guestName.isEmpty()) {
                    return;
                }

                String roomNumberInput = JOptionPane.showInputDialog(frame, "Enter room number to book:");
                int roomNumber;
                try {
                    roomNumber = Integer.parseInt(roomNumberInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid room number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nightsInput = JOptionPane.showInputDialog(frame, "Enter number of nights:");
                int nights;
                try {
                    nights = Integer.parseInt(nightsInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid number of nights.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Room selectedRoom = null;
                for (Room room : rooms) {
                    if (room.roomNumber == roomNumber && room.isAvailable) {
                        selectedRoom = room;
                        break;
                    }
                }

                if (selectedRoom != null) {
                    double costPerNight = 100; // Example cost per night
                    double totalCost = costPerNight * nights;
                    selectedRoom.isAvailable = false;
                    Reservation reservation = new Reservation(guestName, roomNumber, nights, totalCost);
                    reservations.add(reservation);
                    JOptionPane.showMessageDialog(frame, "Reservation successful!\n" + reservation.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Room not available or invalid room number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reservations.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No reservations found.", "Reservations", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder reservationList = new StringBuilder("Reservations:\n\n");
                    for (Reservation reservation : reservations) {
                        reservationList.append(reservation.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, reservationList.toString(), "Reservations", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HotelReservationSystem();
    }
}
