CREATE TABLE post_category (
    "id" bigint PRIMARY KEY,
    "name" varchar(20)
);

CREATE TABLE blog_post (
    "id" bigint PRIMARY KEY,
    "title" varchar(30),
    "contents" varchar(500),
    "post_category_id" bigint,
    "created_at" timestamp,

    FOREIGN KEY ("post_category_id") REFERENCES "post_category" ("id")
);