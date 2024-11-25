console.log("Script loaded");

let currentTheme = getTheme(); // Fetch saved theme
applyTheme(currentTheme); // Apply the theme to the page

// Attach the listener to the theme change button
const changeThemeButton = document.querySelector("#theme_change_button");
if (changeThemeButton) {
    changeThemeButton.addEventListener("click", toggleTheme);
}

// Function to toggle theme
function toggleTheme() {
    const oldTheme = currentTheme;
    currentTheme = currentTheme === "dark" ? "light" : "dark";

    // Update theme in localStorage and DOM
    setTheme(currentTheme);
    document.querySelector("html").classList.replace(oldTheme, currentTheme);

    // Update button text
    updateButtonText();
}

// Function to apply a theme to the page
function applyTheme(theme) {
    document.querySelector("html").classList.add(theme);
    updateButtonText();
}

// Function to update the button text
function updateButtonText() {
    const buttonSpan = document.querySelector("#theme_change_button span");
    if (buttonSpan) {
        buttonSpan.textContent = currentTheme === "light" ? "Dark" : "Light";
    }
}

// Set theme to localStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Get theme from localStorage
function getTheme() {
    return localStorage.getItem("theme") || "light";
}

