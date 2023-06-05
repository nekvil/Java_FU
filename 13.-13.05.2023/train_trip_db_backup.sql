PGDMP         /                {            train_trip_db    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17110    train_trip_db    DATABASE     �   CREATE DATABASE train_trip_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE train_trip_db;
                postgres    false            �            1259    17175    city    TABLE     W   CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.city;
       public         heap    postgres    false            �            1259    17174    city_id_seq    SEQUENCE     �   ALTER TABLE public.city ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    17187    train    TABLE     �   CREATE TABLE public.train (
    id integer NOT NULL,
    number character varying(255),
    name character varying(255),
    train_type_id integer NOT NULL,
    car_count integer,
    seats_per_car integer
);
    DROP TABLE public.train;
       public         heap    postgres    false            �            1259    17186    train_id_seq    SEQUENCE     �   ALTER TABLE public.train ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.train_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    17181 
   train_type    TABLE     ]   CREATE TABLE public.train_type (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.train_type;
       public         heap    postgres    false            �            1259    17180    train_type_id_seq    SEQUENCE     �   ALTER TABLE public.train_type ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.train_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    17200    trip    TABLE     u  CREATE TABLE public.trip (
    id integer NOT NULL,
    train_id integer NOT NULL,
    departure_city integer NOT NULL,
    arrival_city integer NOT NULL,
    departure_date date,
    departure_time time without time zone,
    arrival_date date,
    arrival_time time without time zone,
    available_seats integer,
    total_seats integer,
    base_price numeric(10,2)
);
    DROP TABLE public.trip;
       public         heap    postgres    false            �            1259    17199    trip_id_seq    SEQUENCE     �   ALTER TABLE public.trip ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.trip_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    221                      0    17175    city 
   TABLE DATA           (   COPY public.city (id, name) FROM stdin;
    public          postgres    false    215   M                 0    17187    train 
   TABLE DATA           Z   COPY public.train (id, number, name, train_type_id, car_count, seats_per_car) FROM stdin;
    public          postgres    false    219   �                 0    17181 
   train_type 
   TABLE DATA           .   COPY public.train_type (id, name) FROM stdin;
    public          postgres    false    217   �                  0    17200    trip 
   TABLE DATA           �   COPY public.trip (id, train_id, departure_city, arrival_city, departure_date, departure_time, arrival_date, arrival_time, available_seats, total_seats, base_price) FROM stdin;
    public          postgres    false    221   X!                  0    0    city_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.city_id_seq', 7, true);
          public          postgres    false    214                       0    0    train_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.train_id_seq', 9, true);
          public          postgres    false    218                       0    0    train_type_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.train_type_id_seq', 6, true);
          public          postgres    false    216                       0    0    trip_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.trip_id_seq', 8, true);
          public          postgres    false    220            u           2606    17179    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    215            y           2606    17193    train train_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.train
    ADD CONSTRAINT train_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.train DROP CONSTRAINT train_pkey;
       public            postgres    false    219            w           2606    17185    train_type train_type_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.train_type
    ADD CONSTRAINT train_type_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.train_type DROP CONSTRAINT train_type_pkey;
       public            postgres    false    217            {           2606    17204    trip trip_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.trip
    ADD CONSTRAINT trip_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.trip DROP CONSTRAINT trip_pkey;
       public            postgres    false    221            |           2606    17194    train train_train_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.train
    ADD CONSTRAINT train_train_type_id_fkey FOREIGN KEY (train_type_id) REFERENCES public.train_type(id);
 H   ALTER TABLE ONLY public.train DROP CONSTRAINT train_train_type_id_fkey;
       public          postgres    false    3191    219    217            }           2606    17215    trip trip_arrival_city_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.trip
    ADD CONSTRAINT trip_arrival_city_fkey FOREIGN KEY (arrival_city) REFERENCES public.city(id);
 E   ALTER TABLE ONLY public.trip DROP CONSTRAINT trip_arrival_city_fkey;
       public          postgres    false    215    221    3189            ~           2606    17210    trip trip_departure_city_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.trip
    ADD CONSTRAINT trip_departure_city_fkey FOREIGN KEY (departure_city) REFERENCES public.city(id);
 G   ALTER TABLE ONLY public.trip DROP CONSTRAINT trip_departure_city_fkey;
       public          postgres    false    221    215    3189                       2606    17205    trip trip_train_id_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.trip
    ADD CONSTRAINT trip_train_id_fkey FOREIGN KEY (train_id) REFERENCES public.train(id);
 A   ALTER TABLE ONLY public.trip DROP CONSTRAINT trip_train_id_fkey;
       public          postgres    false    219    3193    221               u   x����`E��N����q�W'0�(� 	��y�C�����m�J�3O�%�,�ޖ����4<��m���#�g�ָL�~X-(XȼB�!qc��įd���m"cǍ���T�         �   x���=N�@�뷧p	E��O��p'�
�� �L���8	���	f��I���@E�Zό�{�bi�Y�{�J4x�=f�P�6�[?��裸�0�
/�y��ǖΜ�����璫KD���Ys�+��s@^K�Eo��R�$Ǖ��	��G����?�A�(����o��;��(�����j��fw�2�/��f*{��Va�ڣ�2�����!��?K�k?0�$n��g�S`n�UI�9�>$\Q         j   x�-��	�@E�*�@���b\Ss�
]����t�f�/1q�Ҋg�F��]R��b�c�a�4�o���p���)z�S[��w�9)�Gd�i'e,"r�P�         �   x���9� ��܅�8�,��9�,#�D����l �X�,5s�Ii�;c m<2����rOq	�ٓM/ ��ث�쿼Fo�r�9f�|	K�SODc[����}�8<���1�����.��dW�Yw�;��}6~���-YK�     