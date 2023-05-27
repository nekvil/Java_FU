-- Create the client table
CREATE TABLE client (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  last_name CHARACTER VARYING(255),
  first_name CHARACTER VARYING(255),
  middle_name CHARACTER VARYING(255),
  date_of_birth DATE
);

-- Create the room_type table
CREATE TABLE room_type (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  name CHARACTER VARYING(255)
);

-- Create the room table
CREATE TABLE room (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  room_type_id INTEGER NOT NULL REFERENCES room_type (id),
  room_number CHARACTER VARYING(255),
  floor_number INTEGER,
  price_per_night DECIMAL(10, 2)
);

-- Create the booking table
CREATE TABLE booking (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  room_id INTEGER NOT NULL REFERENCES room (id),
  client_id INTEGER NOT NULL REFERENCES client (id),
  check_in_date TIMESTAMP WITHOUT TIME ZONE,
  check_out_date TIMESTAMP WITHOUT TIME ZONE,
  total_cost DECIMAL(10, 2)
);

-- Create the additional_service table
CREATE TABLE additional_service (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  name CHARACTER VARYING(255),
  price_per_day DECIMAL(10, 2)
);

-- Create the booking_additional_service table
CREATE TABLE booking_additional_service (
  booking_id INTEGER NOT NULL REFERENCES booking (id),
  additional_service_id INTEGER NOT NULL REFERENCES additional_service (id),
  PRIMARY KEY (booking_id, additional_service_id)
);