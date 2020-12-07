insert into Room_Category(ID_ROOM_CATEGORY, NAME, PRICE,NUMBER, IMAGE,DESCRIPTION) 
values (1, "Phòng Standard", 800000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san.jpg","Phòng tiêu chu?n gi??ng ?ôi" ),
	(2, "Phòng Superior", 1200000, 5,"https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-1.jpg","Phòng 4 ng??i"),
	(3, "Phòng Deluxe", 2000000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-2.jpg","Phòng Deluxe gi??ng ?ôi"),
	(4, "Phòng Suite",2500000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-4.jpg","Phòng Suite Gia ?ình" ),
	(5, "Phòng Connecting",4000000, 3, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-4.jpg","Phòng dành cho gia ?ình");
	
insert INTO Room_Status(ID_ROOM_STATUS, NAME)
VALUES (0, "Phòng tr?ng"), (1, "Phòng ?ang có ng??i ?"), (2, "Phòng ?ã ??t tr??c");

insert INTO Room(ID_ROOM, ID_ROOM_STATUS, ID_ROOM_CATEGORY, FLOOR_NUMBER)
VALUES (101, 0, 1,1), (102, 0, 1,1), (103, 0, 1,1), (104, 0, 1,1), (105, 0, 1,1),
	(106, 0, 1,1), (107, 0, 1,1), (201, 0, 2,2), (202, 0, 2,2), (203, 0, 2,2),
	(204, 0, 2,2), (205, 0, 3,2), (206, 0, 3,2),(207, 0, 3,2), (301, 0, 5,3), (302, 0, 5,3),
	(303, 0, 5,3), (401, 0, 4,4), (402, 0, 4,4), (403, 0,4,4), (404, 0, 4,4);