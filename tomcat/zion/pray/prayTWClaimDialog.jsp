﻿
<!DOCTYPE html>
<html>
<head>
	<title>Page Title</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="//code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css" />
	<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="//code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
	<style>
	html, body { padding: 0; margin: 0; }
	html, .ui-mobile, .ui-mobile body {
    	height: 415px;
	}
	.ui-mobile, .ui-mobile .ui-page {
    	min-height: 415px;
	}
	.ui-content{
		padding:10px 15px 0px 15px;
	}
	</style>
</head>

<body>
<div data-role="dialog">

		<div data-role="header" data-theme="a">
			<h1>Dialog</h1>

		</div>

		<div role="main" class="ui-content">
			<h1>Delete page?</h1>
			<p>This is a regular page, styled as a dialog. To create a dialog, just link to a normal page and include a transition and <code>data-rel="dialog"</code> attribute.</p>
			<a href="example2.html" data-role="button" data-rel="back" data-theme="b">Sounds good</a>
			<a href="example2.html" data-role="button" data-rel="back" data-theme="a">Cancel</a>
		</div>
	</div>

</body>
</html>
