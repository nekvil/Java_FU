PGDMP         '                {            restfull    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16802    restfull    DATABASE     |   CREATE DATABASE restfull WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE restfull;
                postgres    false            �            1259    16803    city    TABLE     R   CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying
);
    DROP TABLE public.city;
       public         heap    postgres    false            �            1259    16846    city_id_seq    SEQUENCE     �   ALTER TABLE public.city ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    16845    city_seq    SEQUENCE     r   CREATE SEQUENCE public.city_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.city_seq;
       public          postgres    false            �            1259    16808    schedule    TABLE     �   CREATE TABLE public.schedule (
    id integer NOT NULL,
    train_id integer NOT NULL,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    city_from integer NOT NULL,
    city_to integer NOT NULL
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            �            1259    16847    schedule_id_seq    SEQUENCE     �   ALTER TABLE public.schedule ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    16811    train    TABLE     �   CREATE TABLE public.train (
    id integer NOT NULL,
    name character varying(250),
    number integer,
    type_id integer NOT NULL
);
    DROP TABLE public.train;
       public         heap    postgres    false            �            1259    16848    train_id_seq    SEQUENCE     �   ALTER TABLE public.train ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.train_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    16814    type    TABLE     W   CREATE TABLE public.type (
    id integer NOT NULL,
    name character varying(250)
);
    DROP TABLE public.type;
       public         heap    postgres    false            �            1259    16849    type_id_seq    SEQUENCE     �   ALTER TABLE public.type ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217                      0    16803    city 
   TABLE DATA           (   COPY public.city (id, name) FROM stdin;
    public          postgres    false    214   N                 0    16808    schedule 
   TABLE DATA           Z   COPY public.schedule (id, train_id, start_time, end_time, city_from, city_to) FROM stdin;
    public          postgres    false    215   �                 0    16811    train 
   TABLE DATA           :   COPY public.train (id, name, number, type_id) FROM stdin;
    public          postgres    false    216   ,                  0    16814    type 
   TABLE DATA           (   COPY public.type (id, name) FROM stdin;
    public          postgres    false    217   �                   0    0    city_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.city_id_seq', 15, true);
          public          postgres    false    219                       0    0    city_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.city_seq', 101, true);
          public          postgres    false    218                        0    0    schedule_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.schedule_id_seq', 10, true);
          public          postgres    false    220            !           0    0    train_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.train_id_seq', 14, true);
          public          postgres    false    221            "           0    0    type_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.type_id_seq', 8, true);
          public          postgres    false    222            v           2606    16818    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    214            x           2606    16820    schedule schedule_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pkey;
       public            postgres    false    215            z           2606    16822    train train_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.train
    ADD CONSTRAINT train_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.train DROP CONSTRAINT train_pkey;
       public            postgres    false    216            |           2606    16824    type type_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.type DROP CONSTRAINT type_pkey;
       public            postgres    false    217            }           2606    16850    schedule city_from_fk    FK CONSTRAINT     u   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT city_from_fk FOREIGN KEY (city_from) REFERENCES public.city(id);
 ?   ALTER TABLE ONLY public.schedule DROP CONSTRAINT city_from_fk;
       public          postgres    false    3190    214    215            ~           2606    16855    schedule city_to_fk    FK CONSTRAINT     q   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT city_to_fk FOREIGN KEY (city_to) REFERENCES public.city(id);
 =   ALTER TABLE ONLY public.schedule DROP CONSTRAINT city_to_fk;
       public          postgres    false    3190    215    214                       2606    16835    schedule train_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT train_id_fk FOREIGN KEY (train_id) REFERENCES public.train(id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.schedule DROP CONSTRAINT train_id_fk;
       public          postgres    false    216    215    3194            �           2606    16840    train type_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.train
    ADD CONSTRAINT type_fk FOREIGN KEY (type_id) REFERENCES public.type(id) ON DELETE CASCADE NOT VALID;
 7   ALTER TABLE ONLY public.train DROP CONSTRAINT type_fk;
       public          postgres    false    217    3196    216               n   x����`D��VA��Ћ��s�"!t�"
$R�ێ8�d';��x�{�ƋѲ��ȏͫ���+M��k�dy���{d��xt,|�XX�]�I�B��b<�rGA_�~1�?(�G�         P   x�����0C�s3ErbJ��t�9(H�\��Z1�SA�UG���]��(!GD�Ype��'�l.+ ��m��܉�<h         Z   x�34�0�¾��v]�ta��Y6\��{/�p���q�r�)Yxa�����%v �{.l��(�}a'��H�1>m51z\\\ �DJ
         e   x�%���0C��L@�g�!� ��#� �Q2�o#�8����`Ç�=�ꀀ�W*��N,\��Zxƛ�$
p:Kc��AG�����%)��Ƞ+E�CSGi     