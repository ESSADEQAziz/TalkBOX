<!DOCTYPE html>
<html>
<head>
	<title>TalkBOX</title>
	<link rel="stylesheet"  href="${pageContext.request.contextPath}/CSS_folder/index.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#features">Features</a></li>
				<li><a href="#pricing">Pricing</a></li>
				<li><a href="#testimonials">Testimonials</a></li>
			</ul>
		</nav>
		<h1>Connect with Your Friends and Family</h1>
		<p>With TalkBOX, you can stay in touch with your loved ones no matter where they are in the world.</p>
	</header>

	<section class="features" id="features">
		<div class="container_flex">
			<div class="feature">
				<img src="./Images/chat_group.jpg" alt="Feature 1">
				<h3>Group Chat</h3>
				<p>With our group chat feature, you can easily chat with multiple friends or family members at the same time.</p>
			</div>
			<div class="feature">
				<img src="./Images/private_chat.jpg" alt="Feature 2">
				<h3>Private Chat</h3>
				<p>If you want to have a private conversation with someone, our private chat feature allows you to do so without any interruptions.</p>
			</div>
			<div class="feature">
				<img src="./Images/video_chat.jpg" alt="Feature 3">
				<h3>Video Chat</h3>
				<p>Our video chat feature allows you to have face-to-face conversations with your friends and family, no matter where they are in the world.</p>
			</div>
		</div>
	</section>

	<section class="pricing" id="pricing">
		<div class="container">
			<div class="price-card">
				<h3>Free</h3>
				<p>Our free plan includes all of the basic features you need to stay in touch with your friends and family.</p>
				<div class="price">$0</div>
				<a href="/App_2/Servlet_1" class="button">Get Started</a>
			</div>
			<div class="price-card">
				<h3>Premium</h3>
				<p>Upgrade to our premium plan for even more features, including group video chat and Hologramme chat.</p>
				<div class="price">$9999.99/month</div>
				<a href="/App_2/Servlet_1" class="button">Upgrade Now</a>
			</div>
		</div>
	</section>

	<section class="testimonials" id="testimonials">
		<div class="container">
			<div class="testimonial">
				<img src="./Images/papa.jpg" alt="Testimonial 1">
				<blockquote>
					<p>This chat app is amazing! It has all of the features I need to stay in touch with my friends and family.</p>
					<cite>Mohamed ESSADEQ</cite>
				</blockquote>
			</div>
			<div class="testimonial">
				<img src="./Images/brouda.jpg" alt="Testimonial 2">
				<blockquote>
					<p>I love using this chat app to chat with my friends who live in other countries. It feels like we're in the same room!</p>
                    <cite>Ayoub ESSADEQ</cite>
                </blockquote>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <p>&copy; 2023 TalkBOX. All rights reserved.</p>
            <ul>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </footer>
</body>
</html>