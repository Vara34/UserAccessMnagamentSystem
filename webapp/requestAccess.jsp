<form action="requestAccess" method="POST">
    <label for="softwareId">Software Name</label>
    <select name="softwareId">
        <!-- Dynamically populate options with software names -->
    </select>
    <label for="accessType">Access Type</label>
    <select name="accessType">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <label for="reason">Reason</label>
    <textarea name="reason" required></textarea>
    <button type="submit">Request Access</button>
</form>
