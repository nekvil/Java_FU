-- Create the City table
CREATE TABLE city (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  name CHARACTER VARYING(255)
);

-- Create the TrainType table
CREATE TABLE train_type (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  name CHARACTER VARYING(255)
);

-- Create the Train table
CREATE TABLE train (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  number CHARACTER VARYING(255),
  name CHARACTER VARYING(255),
  train_type_id INTEGER REFERENCES train_type(id) NOT NULL,
  car_count INTEGER,
  seats_per_car INTEGER
);

-- Create the Trip table
CREATE TABLE trip (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
  train_id INTEGER REFERENCES train(id) NOT NULL,
  departure_city INTEGER REFERENCES city(id) NOT NULL,
  arrival_city INTEGER REFERENCES city(id) NOT NULL,
  departure_date DATE,
  departure_time TIME WITHOUT TIME ZONE,
  arrival_date DATE,
  arrival_time TIME WITHOUT TIME ZONE,
  available_seats INTEGER,
  total_seats INTEGER,
  base_price DECIMAL(10, 2)
);