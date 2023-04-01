PGDMP         "                {         	   aviasales    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16769 	   aviasales    DATABASE     }   CREATE DATABASE aviasales WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE aviasales;
                postgres    false            �            1259    16771    city    TABLE     W   CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying(250)
);
    DROP TABLE public.city;
       public         heap    postgres    false            �            1259    16770    city_id_seq    SEQUENCE     �   ALTER TABLE public.city ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    16793    flight    TABLE     �   CREATE TABLE public.flight (
    id integer NOT NULL,
    route_id integer,
    avia_name character varying(250),
    date_time timestamp without time zone,
    duration integer
);
    DROP TABLE public.flight;
       public         heap    postgres    false            �            1259    16792    flight_id_seq    SEQUENCE     �   ALTER TABLE public.flight ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.flight_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    16777    route    TABLE     c   CREATE TABLE public.route (
    id integer NOT NULL,
    city_from integer,
    city_to integer
);
    DROP TABLE public.route;
       public         heap    postgres    false            �            1259    16776    route_id_seq    SEQUENCE     �   ALTER TABLE public.route ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.route_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217                      0    16771    city 
   TABLE DATA           (   COPY public.city (id, name) FROM stdin;
    public          postgres    false    215   �                 0    16793    flight 
   TABLE DATA           N   COPY public.flight (id, route_id, avia_name, date_time, duration) FROM stdin;
    public          postgres    false    219   ,       	          0    16777    route 
   TABLE DATA           7   COPY public.route (id, city_from, city_to) FROM stdin;
    public          postgres    false    217   �                  0    0    city_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.city_id_seq', 7, true);
          public          postgres    false    214                       0    0    flight_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.flight_id_seq', 4, true);
          public          postgres    false    218                       0    0    route_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.route_id_seq', 5, true);
          public          postgres    false    216            p           2606    16775    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    215            t           2606    16797    flight flight_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_pkey;
       public            postgres    false    219            r           2606    16781    route route_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.route DROP CONSTRAINT route_pkey;
       public            postgres    false    217            u           2606    16782    route city_from_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.route
    ADD CONSTRAINT city_from_fk FOREIGN KEY (city_from) REFERENCES public.city(id) NOT VALID;
 <   ALTER TABLE ONLY public.route DROP CONSTRAINT city_from_fk;
       public          postgres    false    3184    215    217            v           2606    16787    route city_to_fk    FK CONSTRAINT     x   ALTER TABLE ONLY public.route
    ADD CONSTRAINT city_to_fk FOREIGN KEY (city_to) REFERENCES public.city(id) NOT VALID;
 :   ALTER TABLE ONLY public.route DROP CONSTRAINT city_to_fk;
       public          postgres    false    3184    215    217            w           2606    16798    flight route_id_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT route_id_fk FOREIGN KEY (route_id) REFERENCES public.route(id) NOT VALID;
 <   ALTER TABLE ONLY public.flight DROP CONSTRAINT route_id_fk;
       public          postgres    false    219    3186    217               o   x����0D��^@
�jR�!�T��O�djx�Q�>�jF�y�p,���\R9F�d�R�ȥC��W�g՗�]���_޿���`���	-�c��e��ʩ>�z�"���O�            x�3�4�L,I,Rp�,���K-�4202�50�50R04�20 "N3.cNcN�̼D�JT��
�fP��\����&\�taǅv]�waυ�@��;.�+\��xa�-6 L0D2hY� �h4s      	   #   x�3�4�4�2�4�4�2�4�4�2�͸b���� 5d�     