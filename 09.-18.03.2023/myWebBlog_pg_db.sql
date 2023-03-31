PGDMP     ,                    {         	   myWebBlog    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16754 	   myWebBlog    DATABASE        CREATE DATABASE "myWebBlog" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "myWebBlog";
                postgres    false            �            1259    16755    comment    TABLE     �   CREATE TABLE public.comment (
    id integer NOT NULL,
    post_id integer,
    content text,
    created_at timestamp without time zone
);
    DROP TABLE public.comment;
       public         heap    postgres    false            �            1259    16793    comment_seq    SEQUENCE     u   CREATE SEQUENCE public.comment_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.comment_seq;
       public          postgres    false            �            1259    16760    post    TABLE     �   CREATE TABLE public.post (
    id integer NOT NULL,
    title character varying(250),
    content text,
    published_at timestamp without time zone,
    updated_at timestamp without time zone,
    announcement character varying(500)
);
    DROP TABLE public.post;
       public         heap    postgres    false            �            1259    16774    post_seq    SEQUENCE     r   CREATE SEQUENCE public.post_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.post_seq;
       public          postgres    false            �          0    16755    comment 
   TABLE DATA           C   COPY public.comment (id, post_id, content, created_at) FROM stdin;
    public          postgres    false    214   *       �          0    16760    post 
   TABLE DATA           Z   COPY public.post (id, title, content, published_at, updated_at, announcement) FROM stdin;
    public          postgres    false    215   q                  0    0    comment_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.comment_seq', 501, true);
          public          postgres    false    217                       0    0    post_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.post_seq', 301, true);
          public          postgres    false    216            k           2606    16766    comment comment_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.comment DROP CONSTRAINT comment_pkey;
       public            postgres    false    214            m           2606    16768    post post_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.post DROP CONSTRAINT post_pkey;
       public            postgres    false    215            n           2606    16797    comment postId_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.comment
    ADD CONSTRAINT "postId_fkey" FOREIGN KEY (post_id) REFERENCES public.post(id) ON DELETE CASCADE NOT VALID;
 ?   ALTER TABLE ONLY public.comment DROP CONSTRAINT "postId_fkey";
       public          postgres    false    215    214    3181            �   7  x�]R���P��m������N→��2���@|@l+좬+:
�	1q^��_0��%��7AK9~ܙ9g�965=��7�qC��=7�Z��z��ݳ�/��/Q�ǯ�T�<dR=�9�پ���yjr��vh��	@@�w�?Q�;��w�7Eh�@M����DG���^���W2CI-��*��(9�_R����a�c�v��Z��Բ8KA͂�������\h���)V�7���Iz��R���I&[Eć��`��4��MH��pZ���KtN��u���59��8��>&����[�i�k�i��J�Cˉ"H%)I��b0���p#���_^���x�`eA��H5l+3m�"����D����o�8�M������jڻ���!6m��&Fu�6��*䎔�|��=��I�^��L���4N|�?�֘�[���%(���'Fm�l����5��N|�r��Ћ�B�aҡ��NR��HՕ	i��N�Q鲦4�g;l����ǈ�gS��k�[�𮪣+7	�n���G^H�|���W�X���(Gqb�4�A�I�,Q      �      x��[�n�}���_����^x�)VX��K� z�-�`��d�q�vIɔ"Z��$���0,�;�p�B@_0���T����RJ����3��u9u���n�����f�OGi����8��n:H��K.���4r�!=s����cz�������+�����~�%}9M'�P�CO�lo�i�Qї1/t�N�Z���ޔohϬ��=��tH'����ƎݣUc�9��jL+�q����ӵ�s���?ğ{�4�̶�$��Ƨ���mzx���D��p�>;�������$ۢUq>��eܧ��8ޘ��鼛u!�Ӧ�π�BtZL�?��=~�`��8b����oܼ{s=��~٧e��M�s�N��VUS�
�����_p�)�$b��5��&���Ŭ!��r+{��J��)+PN���,�K��h�)�;{ʏ;3�${@�y-8�w.�C�<��Cl��մ�Y�$n7�t(4׌H��8&b3������e��.Vus8�@��#QI�@�[���Hc�=��ĩ�B���[�ı��-8��!	���)|�+�$��B�?y�����P�0��Ny��MVݱ��q�p�7��Chh�EX�r,�n��Q�ޏq��������TtĮ㣣�RtR`����m�P~�J��l�m=_$�����<���;�$�g8
ؓ��'��bx)�b,0�_��5"�f>b����3�F��sH
+��`B.�rD�=��ŝ�nоF@p"���cL
�!�aѵC��)M�G�cx������>҈��R��X���I�ֈ�f¨�m��+aĨ5@��=V	"�k�Xޕ'��i"���5��v�9,��'�]O���@�#��N��A.ǒW?�:�x5jx��D#�!}��mv�l]vr;��dY�y����d顠�:}�mY: �� �V�	���S��j����]�xFH1B��)O�3��~���u-G�����aS���G�+��d5�B9��@��Iv�Ŭ��7{ *�~�PSF(@�3�����jM�|�ؾӃJJ�:�Ƌ��y�>���1��1Y��lw��N��r���B{�y�1�xvyiq��ebW�a]����P\!���uNf�AmNk�0��%Ja�4δ������ڵ*C(��q�PH��N�{��H�g���h-bt�Hu,3F����˴W�=Ξ9O0$�N���Hr���N��Q��l�@X�¯���bw������7�~�&9u�|BRy��<�" �
��X����c!�f��@Y�n�u5�Fr���i�E;��غBp�[8���2l3�2W<
��w?w�m5�"�`_R@9�Y
6f��)��!=Fj$�}6v��p�.@�Y�c�>!A�Y�y�tOK~v��^
�:@�K���n�!�-w(&t��?Sz�r�@�����P@�ي�6�+4 bY�� �G#m�\���)v%�PN�����L��f,��O��!��G�4��Ś!��,��X1K��a�)��8a�@��؟ĭ�5bRc"~�)�4 �bV楝X�ᗲ��v�,��"h�b�*t�S������\'<�b[�N%�c���9�'�k{ʀ�r�N�,�� pU���2����╛�b*`d�ҥ�l�o_+;���?���	�yXsW�6%S�i������V���bs��P�ii��l,4[���\�C�c3F8��Z�,6��B�QI���a��I/�?��K�6�9�`��N�s�?^s����m|�n�sWV�~��1���qnu�r���̐"Y|8{8��X��^���d'	4E�C��5	��oܿ~���:�@��w�^�{��ջk����\�����|	�ϲQ� ���{�e���SXG@�-0��c�5 O��
 �ۃ�3�1Z<Ṙ��;(�d��T�^�D(�ԝ��B���ca���V䏬<�Jb2>�;7�pS�D2��%���R�����y/�n"��*<�R��t$p�~ޖ�rܪiWc�� C�w����>��p������w���kB��^�u�KM�n٥ߦ�J9)vWWo�m������&l-�>���o�'<:-�@��0�+î��<l�s	*_<wDB�oT�R����*P�2
 �ڎУV�ji���R���(��8S ���B����?�l#2��
�ܠdF�we���5�9N������47��* �S�(�R��!^�&�z�)mE�>A�t��8�ﮞ�$��v�����X�4�^U%�)ݥ���NIzd��\n~Z�J�[X�������zt*F]EJ����c�`��U4���y��)���H{l5�f/f����:3�����s�/�l����dЗ�#KE���J��fc�sF���Up��O��a'�r�5=_��=?2�B�I���O�y�g�aXȱ��$�]�mOI��t�Y��(>Ց��#�<.���?�M��H1�6� %i�rW�t���onWA��F���6 0�&dP��)8��UńP�xTk.`��Z`w��.�Xb�c��tŗ��2�N}^�{�ߴ���R��";r��k�C;���%�#&ݴ�Q���!XV��Xs��ܗ�ݯ�J��ݯ�r{~�,�_߿q�y�/ֺ��SN!�ߙC�˛R�U���t���=fFJ�aE�#ݚVӉ�����p.�뮭޹w�#���^��1�*7|M)G6�|k��p��S����U��_w0ߜc��+H$��y:�"��4��(��k�em��)�N���|d*��,��RY�_*�J��8���-��!������|��;LB4G�I�E�)�i����OB����œҊ`@�@�
;r�ۅ�">�)���>o�Y��]�����1�0�ȱ�N%ʀ�{���z��E&.�;�'�4I���=��R�����z E�����+�5�����#]�܄`�;�&2Pf8�O8M�e��Ԇ�����@�JP�(�}����e)����m!Z�������:���~RW��/$Py�!QN#Uq��d��/�?�2�e�9�%��]�t��.Y�c�RWW���@?F<�T�Wg�0�q���V��v#�h+$���R*O>�w6���47�ʲu����*�������9�M�k�	ttl�4�3 �})P�+7�W��vgq�ݞ��;����BgiN�;h0k?���5�ѱ��d��g���MQŶ�mu���dַi���:��K_��@�,>?w��o�^5�@����K���yf,26߮�����؝�޺����%����+i*���J }�
�(#1R������12C�F"G�6�e,A/D���k���^�;!��|�C!�cO��Hi�i�#M�H۶G9G0-�V,�'�Nz:��
�+u���>��ٗ�I��+#���P�$S���0��Q��K!-t���=��jw^��!��&\�}�;��f���m��ű�����{L4�ҋ;��#R��@�V�na0��ϔ}q?���Ю�25ح�+f.�,���s�|͝߸�n��.���5���'�.�h���H��$�4����0����,
�hy��e�j�զ�:�	����������U�6�$���k`�s�g�~��E͝�������k��꣏B�y)���3��=�5 �T���P�B�2���!��7�5~��Wg$�3Ajē���櫡45����L�)΂���6�L���4|)F:��Wx9�g�CP�K�� �6 z0��)im���D0wa�u�d�l"���0cZ�j�=:Uت&{�E��FX���R��Wnh˓�Sk0\A�sG����V{�8�LY�rСD��$�SS/{R��2R���� �kL�����_*��5M��t��H�%�s��S��X�Y�/p]�G�-.E���B����(��@�U�.����K}���\h|�q�ua�����}(�X��{]�k���D�R��pH��B8��2
Gg�:����W��&������"�1�i7��L~�0?����o����;��|�]�2�|�g�� 6�?x��#��L��貤k�p5��E���:�M�V� 8  ��k'�g@Se�C#�2���hO�8"0�����S*��`1�������B���l�p<7߬�|>�Ş����}�S��&��U^R��,��QL;��L������e�-���Z��d��(*��g�z/ы��/�;��/�+sz1���J%��Z�Rq��
w�p�� �.[y�����!�m��[E�����Spks�����=�q�����ߜWI���G!��Y��'M�	�O�rv��Ԙ_n/��K����J��XX<�|vi�l�b��)J��u�$A������7�5q�ƙ��3g��"-��     