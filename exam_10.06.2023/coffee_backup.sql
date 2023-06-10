PGDMP         8        
        {            coffee    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    25051    coffee    DATABASE     z   CREATE DATABASE coffee WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE coffee;
                postgres    false            �            1259    25057    menu    TABLE     s   CREATE TABLE public.menu (
    id integer NOT NULL,
    name character varying(255),
    price double precision
);
    DROP TABLE public.menu;
       public         heap    postgres    false            �            1259    25078    menu_id_seq    SEQUENCE     �   ALTER TABLE public.menu ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    25052    order    TABLE     q   CREATE TABLE public."order" (
    id integer NOT NULL,
    table_id integer,
    total_value double precision
);
    DROP TABLE public."order";
       public         heap    postgres    false            �            1259    25079    order_id_seq    SEQUENCE     �   ALTER TABLE public."order" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    25075 
   order_menu    TABLE     `   CREATE TABLE public.order_menu (
    order_id integer NOT NULL,
    menu_id integer NOT NULL
);
    DROP TABLE public.order_menu;
       public         heap    postgres    false            �            1259    25060    table    TABLE     �   CREATE TABLE public."table" (
    id integer NOT NULL,
    number character varying(255),
    consumer character varying(255)
);
    DROP TABLE public."table";
       public         heap    postgres    false            �            1259    25080    table_id_seq    SEQUENCE     �   ALTER TABLE public."table" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216                      0    25057    menu 
   TABLE DATA           /   COPY public.menu (id, name, price) FROM stdin;
    public          postgres    false    215   �                 0    25052    order 
   TABLE DATA           <   COPY public."order" (id, table_id, total_value) FROM stdin;
    public          postgres    false    214   �                 0    25075 
   order_menu 
   TABLE DATA           7   COPY public.order_menu (order_id, menu_id) FROM stdin;
    public          postgres    false    217   �                 0    25060    table 
   TABLE DATA           7   COPY public."table" (id, number, consumer) FROM stdin;
    public          postgres    false    216                     0    0    menu_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.menu_id_seq', 1, false);
          public          postgres    false    218                       0    0    order_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.order_id_seq', 1, false);
          public          postgres    false    219                       0    0    table_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.table_id_seq', 1, false);
          public          postgres    false    220            v           2606    25066    menu menu_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.menu DROP CONSTRAINT menu_pkey;
       public            postgres    false    215            z           2606    25100    order_menu order_menu_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.order_menu
    ADD CONSTRAINT order_menu_pkey PRIMARY KEY (order_id, menu_id);
 D   ALTER TABLE ONLY public.order_menu DROP CONSTRAINT order_menu_pkey;
       public            postgres    false    217    217            t           2606    25056    order order_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public."order" DROP CONSTRAINT order_pkey;
       public            postgres    false    214            x           2606    25070    table table_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public."table"
    ADD CONSTRAINT table_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public."table" DROP CONSTRAINT table_pkey;
       public            postgres    false    216            |           2606    25081    order_menu menu_id    FK CONSTRAINT     z   ALTER TABLE ONLY public.order_menu
    ADD CONSTRAINT menu_id FOREIGN KEY (menu_id) REFERENCES public.menu(id) NOT VALID;
 <   ALTER TABLE ONLY public.order_menu DROP CONSTRAINT menu_id;
       public          postgres    false    217    3190    215            }           2606    25086    order_menu order_id    FK CONSTRAINT        ALTER TABLE ONLY public.order_menu
    ADD CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES public."order"(id) NOT VALID;
 =   ALTER TABLE ONLY public.order_menu DROP CONSTRAINT order_id;
       public          postgres    false    214    217    3188            {           2606    25101    order table_id    FK CONSTRAINT     |   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT table_id FOREIGN KEY (table_id) REFERENCES public."table"(id) NOT VALID;
 :   ALTER TABLE ONLY public."order" DROP CONSTRAINT table_id;
       public          postgres    false    214    216    3192                  x������ � �            x������ � �            x������ � �            x������ � �     