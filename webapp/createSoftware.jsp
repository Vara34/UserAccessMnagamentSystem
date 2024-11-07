<form action="createSoftware" method="POST">
    <label for="name">Software Name</label>
    <input type="text" name="name" required />
    <label for="description">Description</label>
    <textarea name="description" required></textarea>
    <label for="accessLevels">Access Levels</label>
    <input type="checkbox" name="accessLevels" value="Read"> Read
    <input type="checkbox" name="accessLevels" value="Write"> Write
    <input type="checkbox" name="accessLevels" value="Admin"> Admin
    <button type="submit">Create Software</button>
</form>
