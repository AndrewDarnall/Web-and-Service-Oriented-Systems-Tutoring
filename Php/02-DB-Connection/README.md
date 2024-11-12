# Database Connections

Handling `database` connections in `php` is different than what we've seen in `Java` in the sense that php makes it much easier for us to connect to a backend, given that it has been configured properly.
<br>
<br>

# Php Code Portions

Any code within the `<?php ?>` tags will be interpreted and processed by the `hypertext preprocessor` that is `php` and it returns the approrpriate processed result, wether it be a simple `message` or wether it consists of results from a `query` performed on a database.

---

# Usage

To run the following example you will have to have built the `docker` image of the `database` and then you may run the locally hosted web page.

To amend the database dependency, please refer to the following page:

- [Database Dockerfile](../../sql/README.md)

After fixing the dependencies:

1) Run the database `container`

```bash
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 custom-db
```

2) Then run the `web page` hosted locally from the php preprocessor

```bash
php -S 0.0.0.0:8080
```

After that you will obtain a result such as this

![Top DB Results](../imgs/top-db-results.png)

And

![Bottom DB Results](../imgs/botton-db-results.png)

---