<?php
/**
 * It is ALWAYS better to define connection variables within
 * a separate .php file because:
 * 
 * 1) It is standard practice
 * 2) Security, in case the preprocessor is shut down and
 *    the credentials from the index page, which is served
 *    REGARDLESS from the web server, get dropped as cleartext
 * 
 * Nowadays to avoid said issues, environment  variables which store said
 * secrets are loaded from the deployment machine onto the server
 * 
 * More complex organizations might use other mecchanisms such as SSO
 * or keychains
 */

// Define database connection constants
define('DB_SERVER', '0.0.0.0');
define('DB_USERNAME', 'root');
define('DB_PASSWORD', '123456');
define('DB_NAME', 'Books');

// Establish a MySQLi database connection
// Use the mysqli object-oriented approach
function getDbConnection() {
    // Create the connection
    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
    
    // Check for a successful connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error); // Exit if connection fails
    }
    
    return $conn; // Return the connection object if successful
}
?>
