<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Metadata section -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Viewport settings for responsive design -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Page title displayed in browser tab -->
    <title>Your Page Title Here</title>

    <!-- SEO: Description, keywords, author -->
    <meta name="description" content="A brief description of your page for search engines and social sharing.">
    <meta name="keywords" content="HTML, CSS, JavaScript, boilerplate, web development">
    <meta name="author" content="Your Name or Company">

    <!-- Favicon (browser tab icon) -->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- External CSS stylesheet -->
    <link rel="stylesheet" href="styles.css">

    <!-- Font links (e.g., Google Fonts) -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <!-- Open Graph Metadata (for social media preview cards) -->
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
        <header>
            <h1>Website Title</h1>
            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#services">Services</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </nav>
        </header>

        <!-- Main content area -->
        <main>
            <!-- Section example: Home -->
            <section id="home">
                <h2>Welcome to Our Website</h2>
                <p>This is a boilerplate HTML document with various elements commonly used on modern websites.</p>
            </section>

            <!-- Section example: About -->
            <section id="about">
                <h2>About Us</h2>
                <p>Some information about the website, company, or individual.</p>
            </section>

            <!-- Section example: Services -->
            <section id="services">
                <h2>Our Services</h2>
                <p>Details about the services provided.</p>
            </section>

            <!-- Section example: Contact -->
            <section id="contact">
                <h2>Contact Us</h2>
                <form action="submit_form.php" method="post">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="message">Message:</label>
                    <textarea id="message" name="message" required></textarea>

                    <button type="submit">Send</button>
                </form>
            </section>
        </main>

        <!-- Footer section with copyright and social media links -->
        <footer>
            <p>&copy; 2024 Your Company. All rights reserved.</p>
            <ul class="social-media">
                <li><a href="https://twitter.com/yourprofile" target="_blank">Twitter</a></li>
                <li><a href="https://facebook.com/yourprofile" target="_blank">Facebook</a></li>
                <li><a href="https://linkedin.com/in/yourprofile" target="_blank">LinkedIn</a></li>
            </ul>
        </footer>
    </div>

    <!-- Optional JavaScript to enable specific interactions -->
    <script>
        // JavaScript code can be placed here if needed for quick interactions.
    </script>
</body>

</html>
