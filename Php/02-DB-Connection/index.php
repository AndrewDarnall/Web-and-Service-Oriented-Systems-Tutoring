<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Metadata section -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Page title displayed in browser tab -->
    <title>The Library of Alexandria</title>

    <!-- SEO: Description, keywords, author -->
    <meta name="description" content="A brief description of your page for search engines and social sharing.">
    <meta name="keywords" content="HTML, CSS, JavaScript, boilerplate, web development">
    <meta name="author" content="Your Name or Company">

    <!-- Favicon (browser tab icon) -->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- External CSS stylesheet -->
    <link rel="stylesheet" href="styles.css">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font links (Google Fonts) -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <!-- Open Graph Metadata -->
    <meta property="og:title" content="Your Page Title Here">
    <meta property="og:description" content="A brief description of your page for social media.">
    <meta property="og:image" content="image.jpg">
    <meta property="og:url" content="https://www.yourwebsite.com">
    <meta property="og:type" content="website">

    <!-- Twitter Card Metadata -->
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:title" content="Your Page Title Here">
    <meta name="twitter:description" content="A brief description of your page for Twitter.">
    <meta name="twitter:image" content="image.jpg">

    <!-- Optional: JavaScript file link -->
    <script src="script.js" defer></script>
</head>

<body>
    <!-- Main wrapper for better structure and styling -->
    <div id="wrapper">
        
        <!-- Header section with navigation menu -->
        <header class="bg-primary text-white p-4">
            <div class="container">
                <h1>The Library of Alexandria</h1>
                <nav>
                    <ul class="nav">
                        <li class="nav-item"><a href="#home" class="nav-link text-white">Home</a></li>
                        <li class="nav-item"><a href="#about" class="nav-link text-white">About</a></li>
                        <li class="nav-item"><a href="#services" class="nav-link text-white">Services</a></li>
                        <li class="nav-item"><a href="#contact" class="nav-link text-white">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <!-- Main content area -->
        <main class="container my-5">
            <!-- Section example: Home -->
            <section id="home" class="mb-4">
                <h2>Welcome to Our World-Class Library</h2>
                <p>Feel free to browse our available book collection and choose what best suits you!</p>
            </section>

            <!-- Section example: About -->
            <section id="about" class="mb-4">
                <h2>About Us</h2>
                <p>Founded in 2024, we are the best fictional library to date</p>
            </section>

            <!-- Section example: Services -->
            <section id="services" class="mb-4">
                <h2>Our Services</h2>
                <p>We are proud to state that our dumb examples have helped countless Computer Science undergrads to grasp
                    the basics of web programming and the php language!
                </p>
            </section>

            <?php
            // Include database connection file
            include 'db-connect.php';

            // Get database connection
            $conn = getDbConnection();

            // Check if the connection is successful
            if ($conn) {
                // SQL query to fetch data from the 'books' table (author and title columns)
                $sql = "SELECT title, author FROM books";
                $result = $conn->query($sql);  // Execute the query

                // Start HTML output
                echo '<!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Books List</title>
                    <!-- Bootstrap 5 CDN for styling -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
                </head>
                <body>';

                // Container for the content
                echo '<div class="container mt-5">';

                // Display a heading
                echo '<h1 class="text-center mb-4">Books List</h1>';

                // Check if there are any records
                if ($result->num_rows > 0) {
                    // Start the table
                    echo '<table class="table table-striped table-bordered">';
                    echo '<thead>
                            <tr>
                                <th>Title</th>
                                <th>Author</th>
                            </tr>
                        </thead>';
                    echo '<tbody>';

                    // Loop through each row and display data
                    while($row = $result->fetch_assoc()) {
                        echo '<tr>';
                        echo '<td>' . $row["title"] . '</td>';
                        echo '<td>' . $row["author"] . '</td>';
                        echo '</tr>';
                    }

                    echo '</tbody>';
                    echo '</table>';
                } else {
                    // If no data found
                    echo '<p>No books found.</p>';
                }

                // End of container and body
                echo '</div>';

                // Close the connection
                $conn->close();

                // End HTML document
                echo '</body></html>';
            } else {
                echo "Failed to connect to the database!";
            }
            ?>


        </main>

        <!-- Footer section with copyright and social media links -->
        <footer class="bg-dark text-white py-4">
            <div class="container text-center">
                <p>&copy; 2024 Your Company. All rights reserved.</p>
                <ul class="list-unstyled">
                    <li><a href="https://twitter.com/yourprofile" target="_blank" class="text-white">Twitter</a></li>
                    <li><a href="https://facebook.com/yourprofile" target="_blank" class="text-white">Facebook</a></li>
                    <li><a href="https://linkedin.com/in/yourprofile" target="_blank" class="text-white">LinkedIn</a></li>
                </ul>
            </div>
        </footer>
    </div>

    <!-- Bootstrap 5 JS and Popper (needed for components like dropdowns and modals) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>

</html>
