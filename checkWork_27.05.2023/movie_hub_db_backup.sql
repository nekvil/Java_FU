PGDMP                         {            movie_hub_db    15.2    15.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24995    movie_hub_db    DATABASE     �   CREATE DATABASE movie_hub_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE movie_hub_db;
                postgres    false            �            1259    24997    movie    TABLE     �   CREATE TABLE public.movie (
    id integer NOT NULL,
    name character varying(255),
    genre character varying(255),
    duration integer,
    release integer
);
    DROP TABLE public.movie;
       public         heap    postgres    false            �            1259    24996    movie_id_seq    SEQUENCE     �   ALTER TABLE public.movie ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �          0    24997    movie 
   TABLE DATA           C   COPY public.movie (id, name, genre, duration, release) FROM stdin;
    public          postgres    false    215   �       �           0    0    movie_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.movie_id_seq', 6, true);
          public          postgres    false    214            f           2606    25003    movie movie_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.movie DROP CONSTRAINT movie_pkey;
       public            postgres    false    215            �   �   x�u���0D��*\�'½PLH�
'�baBH��>q��Z�՛��%\�A�@�Ë���
)+���EaTI8b�S��LD�q��4�~��uv��B1ܐx���4o��Kn������R��p�*�wq�y+흼o�>�`i�#�}�ɡI���/d�͐W��R��$��     