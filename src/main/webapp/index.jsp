<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flats online</title>
</head>
<body>
<h3>Display by: </h3>
<form method="post" action="result-page">
    <label for="region">Choose region: </label>
    <select id="region" name="region">
        <option value="center">Center</option>
        <option value="south">South</option>
        <option value="north">North</option>
        <option value="west">West</option>
        <option value="east">East</option>
    </select><br/>
    <label>Area: </label>
    <input type="number" min="50" max="500" step="10" name="area" required/><br/>
    <label>Number of rooms: </label>
    <input type="number" min="1" max="10" step="1" name="no_rooms" required><br/>
    <label>Price: </label>
    <input type="range" value="50000" min="5000" max="100000" step="5000" name="price" required
           oninput="amount.value=price.value">
    <output id="amount" name="amount" for="rangeInput">50000</output><br/>
    <button>
        Display
    </button>
</form>
</body>
</html>