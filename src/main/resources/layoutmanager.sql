INSERT INTO user (username , password, role) VALUES 
('john_doe', 'password123', 'USER'),
('jane_admin', 'securepass', 'ADMIN'),
('alice', 'alicepass', 'USER');

select * from user;


INSERT INTO layout (name) VALUES 
('Homepage Layout'),
('Dashboard'),
('Profile'),
('Settings'),
('Login');

select * from layout l ;

select * from layout_assignment la;