Assessment Task: University Computer Reservation System - Stage Two

Your task for AE2 is to complete the development of the university room booking system by developing a GUI application using Kotlin, Compose Multiplatform, and SQLite. You must use the group-developed code from the Group Project submission as your starting point or a model Group Project answer prepared by the tutor (to be released shortly after the late submission date for AE1).

The GUI application must meet the following requirements (note some have been modified from AE1):

Store rooms, bookings, and users in the SQLite database.
Load this data back from the database when the application starts.
Key Features:
Room Search

Students can search for rooms by:
Building
Computer operating system type (Windows, Mac, Linux)
User Management

Students can sign up and log in.
Distinguish between regular users (students) and administrators.
Booking

Students can book individual computers in rooms for specific days and times.
Inform the user of their allocated computer ID (e.g., JM606-12 means room JM606, computer 12).
Admin Features

View all bookings for a given day and time, showing:
Computers in the room
Slots booked
Slots available
Add new rooms, specifying:
Number of computers (multiples of five)
Time slots for each room
Change the type of computer in an existing room.
Booking Management

Students can view and cancel previous bookings.
Graphical Room View

Display room layouts with the status of each computer:
Reserved: Red
Unreserved: Green
Current user's bookings: Purple
Enable booking of unreserved computers or canceling existing bookings.
Summary
This task involves creating a Kotlin GUI application for a university room reservation system using Compose Multiplatform and SQLite. The app will have features for students and administrators, allowing them to manage room bookings, add rooms, and view room availability. Graphical representations and user roles (students and admins) are integral parts of the project.