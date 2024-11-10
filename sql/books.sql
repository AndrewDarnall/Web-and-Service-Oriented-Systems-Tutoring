-- Book Database for Book Store

CREATE SCHEMA Books;

USE Books;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(150) NOT NULL,
    title VARCHAR(180) NOT NULL,
    genre VARCHAR(30) NOT NULL,
    rating FLOAT,
    CHECK (rating >= 0.0 AND rating <= 5.0)
);

INSERT INTO books (author, title, genre, rating) VALUES
("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", "Introduction to Algorithms 4th Edition", "Textbook", 5.0),
("Bjarne Stroustrup", "The C++ Programming Language", "Textbok", 5.0),
("Ian Goodfellow, Yoshua Bengio, Aaron Courville", "Deep Learning", "Awesome", 5.0),
("Antonio Torralba, Phillip Isola, William T. Freeman", "Foundations of Computer Vision", "More Awesome", 5.0),
("Erich Gamma, Richard Helm, Realph Johnson, John Vlissides", "Design Patterns: elements of reusable object-oriented software", "History", 5.0),
("James F. Kurose, Keith Ross", "Computer Networking 8th Edition", "Basics", 3.5),
("Andrew S. Tanebaum, Herbert Bos", "Modern Operating Systems 5th Edition", "Linus Bible", 3.5),
("Andrew S. Tanbaum, Todd Austin", "Structured Computer Organization", "Foundational", 3.5),
("Eric Lehman, F. Tom Leighton, Albert R. Meyer", "Mathematics for Computer Science", "Basics", 5.0),
("Rafael C. Gonzalez, Richard E. Woods", "Digital Image Processing 4th Edition", "Backbone", 2.0),
("William Stallings", "Cryptography and Network Security 8th Edition", "Cyber-cool", 4.5),
("Jure Leskovec, Anand Rajaraman, Jeffery David Ullman", "Mining of Massive Datasets", "Money", 4.0),
("Mihir Bellare, Phillip Rogaway", "Introduction to Modern Cryptography", "Crypto-is-cool", 3.0),
("Arvind Narayanan, Joseph Bonneau, Edward Felten, Andrew Miller, Steven Goldfeder", "Bitcoin and Cryptocurrency Technologies: A Comprehensive Introduction", "Money", 3.0),
("Richard J. Lipton, Kenneth W. Regan", "Quantum Algorithms via Linear Algebra", "Quantum-mania", 3.5);