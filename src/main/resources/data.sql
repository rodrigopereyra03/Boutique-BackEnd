-- INSERT para agregar un nuevo Cliente a la tabla
INSERT INTO client (dni, name, last_name, premium, services_taken) VALUES (12345678, 'Nombre', 'Apellido', false, 0);
INSERT INTO client (dni, name, last_name, premium, services_taken) VALUES (24531687, 'Nombre1', 'Apellido1', false, 2);
INSERT INTO client (dni, name, last_name, premium, services_taken) VALUES (4523781, 'Nombre2', 'Apellido2', true, 6);

-- INSERT para agregar un nuevo Servicio a la tabla
INSERT INTO service_boutique (name, service_type, price) VALUES ('Lavado', 'LAVADO_BASICO', 50.00);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Lavado', 'LAVADO_COMPLETO', 100.00);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Lavado', 'LAVADO_PREMIUM', 200);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Alineacion y balanceo', 'ALINEACION_BASICO', 150.00);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Alineacion y balanceo', 'ALINEACION_COMPLETO', 300.00);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Aceite Basico', 'ACEITE_BASICO', 200.00);
INSERT INTO service_boutique (name, service_type, price) VALUES ('Aceite', 'ACEITE_COMPLETO', 350.00);

-- INSERT para agregar un nuevo Auto a la tabla
INSERT INTO car (patent) VALUES ('AAA111');
INSERT INTO car (patent) VALUES ('AA111AA');

-- INSERT para agregar un nuevo registro a la tabla WorkOrder
INSERT INTO work_order (local_date_time, client_id, car_id, total_price) VALUES ('2024-04-16T12:00:00', 1, 1, 300);
INSERT INTO work_order (local_date_time, client_id, car_id, total_price) VALUES ('2024-04-26T10:00:00', 2, 2, 150);
INSERT INTO work_order (local_date_time, client_id, car_id, total_price) VALUES ('2024-04-30T11:00:00', 3, 1, 450);
INSERT INTO work_order (local_date_time, client_id, car_id, total_price) VALUES ('2024-05-01T17:00:00', 2, 2, 750);



-- Insertar asociaciones ManyToMany entre la orden de trabajo y los servicios
INSERT INTO wor_order_services (work_order_id, service_id)
VALUES (1, 6),  -- work_order_id y service_id corresponden a los IDs generados de las entidades
       (1, 2);

INSERT INTO wor_order_services (work_order_id, service_id)
VALUES (2, 4);

INSERT INTO wor_order_services (work_order_id, service_id)
VALUES (3, 7),
       (3, 2);

INSERT INTO wor_order_services (work_order_id, service_id)
VALUES (4, 7),
       (4, 2),
       (4, 5)




