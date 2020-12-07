insert into Room_Category(ID_ROOM_CATEGORY, NAME, PRICE,NUMBER, IMAGE,DESCRIPTION) 
values (1, "Ph�ng Standard", 800000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san.jpg","Ph�ng ti�u chu?n gi??ng ?�i" ),
	(2, "Ph�ng Superior", 1200000, 5,"https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-1.jpg","Ph�ng 4 ng??i"),
	(3, "Ph�ng Deluxe", 2000000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-2.jpg","Ph�ng Deluxe gi??ng ?�i"),
	(4, "Ph�ng Suite",2500000, 5, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-4.jpg","Ph�ng Suite Gia ?�nh" ),
	(5, "Ph�ng Connecting",4000000, 3, "https://www.hoteljob.vn/files/VB2-%E1%BA%A3nh%20HTJ/cac-loai-phong-trong-khach-san-4.jpg","Ph�ng d�nh cho gia ?�nh");
	
insert INTO Room_Status(ID_ROOM_STATUS, NAME)
VALUES (0, "Ph�ng tr?ng"), (1, "Ph�ng ?ang c� ng??i ?"), (2, "Ph�ng ?� ??t tr??c");

insert INTO Room(ID_ROOM, ID_ROOM_STATUS, ID_ROOM_CATEGORY, FLOOR_NUMBER)
VALUES (101, 0, 1,1), (102, 0, 1,1), (103, 0, 1,1), (104, 0, 1,1), (105, 0, 1,1),
	(106, 0, 1,1), (107, 0, 1,1), (201, 0, 2,2), (202, 0, 2,2), (203, 0, 2,2),
	(204, 0, 2,2), (205, 0, 3,2), (206, 0, 3,2),(207, 0, 3,2), (301, 0, 5,3), (302, 0, 5,3),
	(303, 0, 5,3), (401, 0, 4,4), (402, 0, 4,4), (403, 0,4,4), (404, 0, 4,4);