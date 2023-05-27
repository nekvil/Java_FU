PGDMP     /    -    
            {            booking_management_db    15.2    15.2 %    )           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            *           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            +           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ,           1262    17111    booking_management_db    DATABASE     �   CREATE DATABASE booking_management_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
 %   DROP DATABASE booking_management_db;
                postgres    false            �            1259    17154    additional_service    TABLE     �   CREATE TABLE public.additional_service (
    id integer NOT NULL,
    name character varying(255),
    price_per_day numeric(10,2)
);
 &   DROP TABLE public.additional_service;
       public         heap    postgres    false            �            1259    17153    additional_service_id_seq    SEQUENCE     �   ALTER TABLE public.additional_service ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.additional_service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    223            �            1259    17138    booking    TABLE     �   CREATE TABLE public.booking (
    id integer NOT NULL,
    room_id integer NOT NULL,
    client_id integer NOT NULL,
    check_in_date timestamp without time zone,
    check_out_date timestamp without time zone,
    total_cost numeric(10,2)
);
    DROP TABLE public.booking;
       public         heap    postgres    false            �            1259    17159    booking_additional_service    TABLE     �   CREATE TABLE public.booking_additional_service (
    booking_id integer NOT NULL,
    additional_service_id integer NOT NULL
);
 .   DROP TABLE public.booking_additional_service;
       public         heap    postgres    false            �            1259    17137    booking_id_seq    SEQUENCE     �   ALTER TABLE public.booking ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    221            �            1259    17113    client    TABLE     �   CREATE TABLE public.client (
    id integer NOT NULL,
    last_name character varying(255),
    first_name character varying(255),
    middle_name character varying(255),
    date_of_birth date
);
    DROP TABLE public.client;
       public         heap    postgres    false            �            1259    17112    client_id_seq    SEQUENCE     �   ALTER TABLE public.client ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    17127    room    TABLE     �   CREATE TABLE public.room (
    id integer NOT NULL,
    room_type_id integer NOT NULL,
    room_number character varying(255),
    floor_number integer,
    price_per_night numeric(10,2)
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    17126    room_id_seq    SEQUENCE     �   ALTER TABLE public.room ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    17121 	   room_type    TABLE     \   CREATE TABLE public.room_type (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.room_type;
       public         heap    postgres    false            �            1259    17120    room_type_id_seq    SEQUENCE     �   ALTER TABLE public.room_type ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            %          0    17154    additional_service 
   TABLE DATA           E   COPY public.additional_service (id, name, price_per_day) FROM stdin;
    public          postgres    false    223   �+       #          0    17138    booking 
   TABLE DATA           d   COPY public.booking (id, room_id, client_id, check_in_date, check_out_date, total_cost) FROM stdin;
    public          postgres    false    221   W,       &          0    17159    booking_additional_service 
   TABLE DATA           W   COPY public.booking_additional_service (booking_id, additional_service_id) FROM stdin;
    public          postgres    false    224   �,                 0    17113    client 
   TABLE DATA           W   COPY public.client (id, last_name, first_name, middle_name, date_of_birth) FROM stdin;
    public          postgres    false    215   �,       !          0    17127    room 
   TABLE DATA           \   COPY public.room (id, room_type_id, room_number, floor_number, price_per_night) FROM stdin;
    public          postgres    false    219   �-                 0    17121 	   room_type 
   TABLE DATA           -   COPY public.room_type (id, name) FROM stdin;
    public          postgres    false    217   .       -           0    0    additional_service_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.additional_service_id_seq', 6, true);
          public          postgres    false    222            .           0    0    booking_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.booking_id_seq', 29, true);
          public          postgres    false    220            /           0    0    client_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.client_id_seq', 5, true);
          public          postgres    false    214            0           0    0    room_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.room_id_seq', 6, true);
          public          postgres    false    218            1           0    0    room_type_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.room_type_id_seq', 6, true);
          public          postgres    false    216            �           2606    17158 *   additional_service additional_service_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.additional_service
    ADD CONSTRAINT additional_service_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.additional_service DROP CONSTRAINT additional_service_pkey;
       public            postgres    false    223            �           2606    17163 :   booking_additional_service booking_additional_service_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.booking_additional_service
    ADD CONSTRAINT booking_additional_service_pkey PRIMARY KEY (booking_id, additional_service_id);
 d   ALTER TABLE ONLY public.booking_additional_service DROP CONSTRAINT booking_additional_service_pkey;
       public            postgres    false    224    224            �           2606    17142    booking booking_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
       public            postgres    false    221            ~           2606    17119    client client_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    215            �           2606    17131    room room_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    219            �           2606    17125    room_type room_type_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.room_type
    ADD CONSTRAINT room_type_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.room_type DROP CONSTRAINT room_type_pkey;
       public            postgres    false    217            �           2606    17169 P   booking_additional_service booking_additional_service_additional_service_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.booking_additional_service
    ADD CONSTRAINT booking_additional_service_additional_service_id_fkey FOREIGN KEY (additional_service_id) REFERENCES public.additional_service(id);
 z   ALTER TABLE ONLY public.booking_additional_service DROP CONSTRAINT booking_additional_service_additional_service_id_fkey;
       public          postgres    false    223    3206    224            �           2606    17164 E   booking_additional_service booking_additional_service_booking_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.booking_additional_service
    ADD CONSTRAINT booking_additional_service_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES public.booking(id);
 o   ALTER TABLE ONLY public.booking_additional_service DROP CONSTRAINT booking_additional_service_booking_id_fkey;
       public          postgres    false    224    3204    221            �           2606    17148    booking booking_client_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(id);
 H   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_client_id_fkey;
       public          postgres    false    215    221    3198            �           2606    17143    booking booking_room_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.room(id);
 F   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_room_id_fkey;
       public          postgres    false    219    3202    221            �           2606    17132    room room_room_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_room_type_id_fkey FOREIGN KEY (room_type_id) REFERENCES public.room_type(id);
 E   ALTER TABLE ONLY public.room DROP CONSTRAINT room_room_type_id_fkey;
       public          postgres    false    217    3200    219            %   `   x�=ɱ� F��n
bq�8���D�P"�?Ibb��Y��R̓¡p# !T��sOΊhv���X�'��!��Hy�����mw��_�2`      #   `   x��ͻ� К��@��c��?G��I���9��@4��pdt-�]�l]f�
��Ԡ#k��c�N^W�<Y�zpm;5�����o��=�ӕ���)1�      &   #   x�32�4�22�F\F� �9�e	bYY1z\\\ q�g         �   x�m�K�@D��w� �.ظqa\�1����~�Ps#1w�U���
.x��!lѣ�0�s��j������F�s�D��Nc��j�;���~��Ll"�k���S�L͞ϙ�S���[��dSc�&��P��q� ����8v��#-�p��2��Y��lv��      !   J   x�-���0�fd�e�~��%�q�>p8�փERIYX�"��Jf����=Vb�ك�c�Զy�}*"?O�         �   x�}�;�P����*(�1Ap�P��%T����-!�(�pΎc%$v����������ab����zZ�\�0e�(h=U_�}�D�5/,$���ς��+5}����1ש[z	�LX�o��1��y'"3�C��     